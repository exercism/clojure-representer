(ns clojure-representer.main
  (:require [clojure-representer.analyzer.jvm :as ana.jvm]
            [clojure-representer.analyzer.passes.jvm.emit-form :as e]
            [clojure-representer.analyzer.passes.uniquify :refer [mappings placeholder]]
            [clojure.tools.deps.alpha.repl :refer [add-libs]]
            [clojure.java.io :as io]
            [clojure.string :as str]
            [rewrite-clj.zip :as z]
            [clojure.data.json :as json]
            [clojure.pprint :as pp])
  (:import [java.nio.file Files  LinkOption Path]
           [java.net URI]))

(defn- as-path
  ^Path [path]
  (if (instance? Path path) path
      (if (instance? URI path)
        (java.nio.file.Paths/get ^URI path)
        (.toPath (io/file path)))))

(defn- ->link-opts ^"[Ljava.nio.file.LinkOption;"
  [nofollow-links]
  (into-array LinkOption
              (cond-> []
                nofollow-links
                (conj LinkOption/NOFOLLOW_LINKS))))

(defn exists?
  "Returns true if f exists."
  ([f] (exists? f nil))
  ([f {:keys [:nofollow-links]}]
   (try
     (Files/exists
      (as-path f)
      (->link-opts nofollow-links))
     (catch Exception _e
       false))))

(defn deps [path]
  (-> path
      z/of-file
      (z/find-value z/next :dependencies)
      z/right
      z/sexpr))

(defn edn-dep [lein-dep]
  (let [[id version] lein-dep]
    {id {:mvn/version version}}))

(defn hot-load-deps [path]
  (doseq [dep (deps path)]
    (add-libs (edn-dep dep))))

(defn normalize 
  "Takes a Java.io.File containing Clojure code
   and outputs a string representing a normalized, 
   fully macroexpanded version of itself."
  [f]
  (-> (str f)
      z/of-file
      z/up
      z/sexpr
      ana.jvm/analyze+eval
      e/emit-hygienic-form
      str))

(defn represent [{:keys [slug in-dir out-dir]}]
  (let [file           (str (str/replace slug "-" "_") ".clj")
        lein-config    (io/file in-dir ".." "project.clj")
        _              (reset! placeholder 0)
        _              (reset! mappings {})
        representation (-> (io/file in-dir file)
                           normalize
                           z/of-string
                           ;(z/find-value z/next (symbol "PLACEHOLDER-0"))
                           ;z/up
                           ;z/remove
                           ;z/up z/up z/up z/up
                           z/sexpr
                           )]
    (when (exists? lein-config)
      (hot-load-deps (str lein-config)))
    (spit (str (io/file out-dir "mapping.json"))
          (json/write-str (into {} (map (fn [[k v]] [v k]) 
                                        @mappings))))
    (spit (str (io/file out-dir "representation.txt"))
          (with-out-str (pp/pprint representation)))))

(defn -main [slug in-dir out-dir]
  (represent {:slug slug :in-dir in-dir :out-dir out-dir}))
