#!/usr/bin/env bb

(require '[babashka.fs :as fs]
         '[cheshire.core :as json]
         '[clojure.java.shell :as shell]
         '[clojure.string :as str]
         '[clojure.edn :as edn]
         '[rewrite-clj.zip :as z]
         '[rewrite-clj.parser :as p]
         '[rewrite-clj.node :as n])

(def slug (first *command-line-args*))
(def in-dir (str (fs/path (second *command-line-args*))))
(def out-dir (str (fs/path (last *command-line-args*))))

(defn solution-nodes 
  "Parses a solution and converts it to
   a depth-first sequence of nodes.
   Removes whitespace, newlines and comments."
  [slug in-dir]
  (let [file (str (str/replace slug "-" "_") ".clj")
        parsed (p/parse-file-all (str (fs/path in-dir file)))]
  (remove #(or (n/whitespace-or-comment? %)
               (n/inner? %)) 
          (tree-seq n/inner? n/children parsed))))


(for [node (solution-nodes "two-fer" "resources/twofers/0/")]
  (if (n/sexpr-able? node)
    (n/sexpr node)
    (n/tag node)))

(n/tag (nth 
        (solution-nodes "two-fer" "resources/twofers/0/")
        3))

;; for testing

(defn solution-src
  "Given a solution `slug` and a number from 0 to 500,
   returns a string representing the file path of the 
   solution to be tested.

   Example:
  `(solution-src \"two-fer\" 0)`"
  [slug n]
  (let [dir (str/replace slug "-" "_")
        file (str dir ".clj")]
    (str (fs/path "resources" dir (str n) "src" file))))

(def analysis
  (let [cmd ["clj-kondo" "--lint" (str (fs/file in-dir (str (str/replace slug "-" "_") ".clj"))) "--config"
             "{:output {:format :edn},:analysis {:locals true :arglists true}}"]]
    (:analysis (edn/read-string (:out (apply shell/sh cmd))))))

(def locals
  (let [rows (->> analysis
                  :locals
                  (into (:local-usages analysis))
                  (map #(select-keys % [:name :row :col]))
                  (filter :name)
                  (group-by :row)
                  (map last))
        cols (map #(sort-by :col %) rows)]
    (flatten (sort-by #(:row (first %)) cols))))

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

(def test-file
  (str (fs/file in-dir (str (str/replace "-" "_" slug) ".clj"))))

(def impl-zip
  (z/of-file test-file {:track-position? true}))

(def parsed-test-file
  (p/parse-file-all test-file))


(defn replace-local [z {:keys [name row col]}]
  (z/replace (z/find-last-by-pos z [row col]) 
             (get placeholders (str name))))

(defn arglists [var-def]
  (let [lists (map edn/read-string (:arglist-strs var-def))]
    (into [] (for [list lists]
               {:var  (:name var-def)
                :args list}))))

(defn replace-arglist [z arglist]
    (-> z
        (z/find-value z/next (:var arglist))
        (z/find-next-depth-first #(= (:args arglist) (z/sexpr %)))
        (z/replace (mapv #(symbol (get placeholders (str %)))
                         (:args arglist)))))

(defn replace-locals [zloc]
  (loop [z zloc idents locals]
    (if (empty? idents) (println (z/root-string z))
        (recur (z/of-string (z/root-string (replace-local z (last idents)))
                            {:track-position? true})
               (butlast idents)))))

(defn represent [zloc]
  (spit (str (fs/path out-dir "representation.txt")) 
        (with-out-str (->
                       (reduce replace-arglist zloc
                               (mapcat arglists (:var-definitions analysis)))
                       (replace-locals)
                       z/root-string)))
  (println (str "Representation written to " (fs/file out-dir "representation.txt"))))

(represent impl)

(System/exit 0)
