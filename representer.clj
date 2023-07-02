(ns representer
  (:require [rewrite-clj.node :as n]
            [rewrite-clj.zip :as z]
            [rewrite-clj.parser :as p]
            [clojure.edn :as edn]
            [clojure.java.shell :as shell]
            [cheshire.core :as json]))

(defn analyze [f]
  (let [cmd ["clj-kondo" "--lint" (str f) "--config"
             "{:output {:format :edn},:analysis {:locals true :arglists true}}"]]
    (:analysis (edn/read-string (:out (apply shell/sh cmd))))))

(def src (str "resources/armstrong_numbers/" 0 "/src/armstrong_numbers.clj"))

(:locals (analyze src))

(defn locals [f]
  (let [rows (->> (analyze f)
                  :locals
                  (into (:local-usages (analyze f)))
                  (map #(select-keys % [:name :row :col]))
                  (filter :name)
                  (group-by :row)
                  (map last))
        cols (map #(sort-by :col %) rows)]
    (flatten (sort-by #(:row (first %)) cols))))

(locals src)

(def placeholders
  (let [args (->> analysis
                  :var-definitions
                  (mapcat :arglist-strs)
                  (mapcat edn/read-string)
                  (map str)
                  set)
        locals (map str (map :name (:local-usages analysis)))
        placeholders (map #(str "PLACEHOLDER-" %)
                          (range 1 (inc (+ (count locals) (count args)))))]
    (println (str out-dir))
    (spit (str (fs/path out-dir "mapping.json"))
          (json/generate-string
           (into (sorted-map-by
                  (fn [key1 key2]
                    (< (parse-long (last (str/split key1 #"-")))
                       (parse-long (last (str/split key2 #"-"))))))
                 (zipmap placeholders (into args locals)))
           {:pretty true}))
    (println (str "Placeholders written to " (fs/file out-dir "mapping.json")))
    (zipmap (into args locals) placeholders)))

(defn test-zip [f]
  (z/of-file (str f)))

(p/parse-string-all (slurp (test-zip "test-suites\\armstrong_numbers_test.clj")))

(defn assertion?
  "Returns true if the given node is an `is`."
  [loc]
  (= (symbol 'is) (-> loc z/down z/sexpr)))

(defn is-forms
  "Returns a sequence of zippers representing all the `is` assertions."
  [z]
  (->> z
       (iterate #(z/find-next-depth-first % assertion?))
       rest
       (take-while some?)))

(map z/sexpr (is-forms (test-zip "test-suites\\armstrong_numbers_test.clj")))

(->>
 (first (is-forms (test-zip "test-suites\\armstrong_numbers_test.clj")))
 z/next
 z/tag)

(->>
 (test-zip "test-suites\\armstrong_numbers_test.clj")
 (iterate z/next)
 (take-while some?)
 (map z/sexpr)
 count)

(def solution-file (str "resources/armstrong_numbers/" 0 "/src/armstrong_numbers.clj"))

(def forms (n/children (p/parse-string-all (slurp solution-file))))

(def ns-node (first forms))

(def impl-node (last forms))

ns-node
impl-node

(n/sexpr impl-node)