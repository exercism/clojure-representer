#!/usr/bin/env bb

(require '[rewrite-clj.zip :as z]
         '[rewrite-clj.node :as n]
         '[clojure.java.shell :as shell]
         '[clojure.string :as str]
         '[clojure.edn :as edn]
         '[cheshire.core :as json])

(def slug (first *command-line-args*))
(def in-dir (second *command-line-args*))
(def out-dir (last *command-line-args*))

(comment
  (def slug "test-code")
  (def in-dir "./resources/")
  (def out-dir "./resources/")
  )

(defn snake-case [kebab-case]
  (str/replace kebab-case "-" "_"))

(def analysis
  (let [cmd ["./clj-kondo" "--lint" (str in-dir (snake-case slug) ".clj") "--config"
             "{:output {:format :edn},:analysis {:locals true :arglists true}}"]]
    (:analysis (edn/read-string (:out (apply shell/sh cmd))))))

(def locals
  (filter :name (map #(select-keys % [:name :row :col])
                     (:local-usages analysis))))

(def placeholders
  (let [args (->> analysis
                  :var-definitions
                  (mapcat :arglist-strs)
                  (mapcat edn/read-string)
                  (map str)
                  set)
        placeholders (map #(str "PLACEHOLDER-" %) 
                          (range 1 (inc (count args))))]
    (spit (str out-dir "mapping.json") 
          (json/generate-string 
           (into (sorted-map-by 
                  (fn [key1 key2]
                    (< (parse-long (last (str/split key1 #"-")))
                       (parse-long (last (str/split key2 #"-"))))))
                 (zipmap placeholders args))
           {:pretty true}))
    (zipmap args placeholders)))

(def impl
  (z/of-file (str in-dir (snake-case slug) ".clj")))

(let [var-def (first (:var-definitions analysis))
      args (mapcat edn/read-string (:arglist-strs var-def))]
  (-> impl
      (z/find-value z/next (:name var-def))
      (z/find-value z/next (first args))
      (z/replace (symbol "PLACEHOLDER1"))
      z/root-string
      println))
