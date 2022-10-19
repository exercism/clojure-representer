(ns exercism.clojure-representer
  (:require [clojure.java.shell :as shell]
            [clojure.edn :as edn]
            [clojure.string :as str]
            [clojure.java.io :as io]
            [rewrite-clj.zip :as z]
            [clojure.tools.analyzer.jvm :as ana.jvm]
            [clojure.tools.analyzer.env :refer [with-env]]
            [clojure.tools.analyzer.passes.jvm.emit-form :as e]
            [clojure.tools.analyzer.passes.uniquify :as u]))

(def slug "two-fer")
(def in-dir "0")

(defn- read-one
  [r]
  (try
    (read r)
    (catch java.lang.RuntimeException e
      (if (= "EOF while reading" (.getMessage e))
        ::EOF
        (throw e)))))

(defn read-seq-from-file
  "Reads a sequence of top-level objects in file at path."
  [path]
  (with-open [r (java.io.PushbackReader. (clojure.java.io/reader path))]
    (binding [*read-eval* false]
      (doall (take-while #(not= ::EOF %) (repeatedly #(read-one r)))))))

(defn impl [in-dir]
  (read-seq-from-file
   (str (io/file (str "resources/twofers/" in-dir)
                 (str (str/replace slug "-" "_") ".clj")))))

(defn represent [forms]
  (let [macroexpanded (apply str (map #(e/emit-hygienic-form
                                        (ana.jvm/analyze+eval %))
                                      forms))
        locals        (set (re-seq #"\w+__#\d+" macroexpanded))
        placeholders  (map #(str "PLACEHOLDER-" %)
                           (range 1 (inc (count locals))))
        mapping       (zipmap locals placeholders)]
    (reduce (fn [s m] (str/replace s m (get mapping m)))
            macroexpanded locals)))

(set (map
      #(represent (impl (str %)))
      (range 500)))
