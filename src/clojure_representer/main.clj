(ns clojure-representer.main
  (:require [clojure-representer.analyzer.jvm :as ana.jvm]
            [clojure-representer.analyzer.passes.jvm.emit-form :as e]
            [clojure-representer.analyzer.passes.uniquify :refer [mappings placeholder]]
            [clojure.tools.deps.alpha.repl :refer [add-libs]]
            [clojure.java.io :as io]
            [clojure.string :as str]
            [rewrite-clj.zip :as z]
            [clojure.data.json :as json]
            [clojure.pprint :as pp]))

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
        _ (hot-load-deps (str (io/file in-dir ".." "project.clj")))
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
    (spit (str (io/file out-dir "mapping.json"))
          (json/write-str (into {} (map (fn [[k v]] [v k]) 
                                        @mappings))))
    (spit (str (io/file out-dir "expected-representation.txt"))
          (with-out-str (pp/pprint representation)))))

  (represent {:slug    "armstrong-numbers"
              :in-dir  (str "resources/armstrong_numbers/6/src/")
              :out-dir (str "resources/armstrong_numbers/6/src/")})

  (doseq [n (range 100 102)]
    (represent {:slug    "armstrong-numbers"
                :in-dir  (str "resources/armstrong_numbers/" n "/src/")
                :out-dir (str "resources/armstrong_numbers/" n "/src/")}))

(defn -main [slug in-dir out-dir]
  (represent {:slug slug :in-dir in-dir :out-dir out-dir}))
