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
  (let [rows (map last (group-by :row
                                 (filter :name (map #(select-keys % [:name :row :col])
                                                    (into (:local-usages analysis)
                                                          (:locals analysis))))))
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
    (spit (str out-dir "mapping.json") 
          (json/generate-string 
           (into (sorted-map-by 
                  (fn [key1 key2]
                    (< (parse-long (last (str/split key1 #"-")))
                       (parse-long (last (str/split key2 #"-"))))))
                 (zipmap placeholders (into args locals)))
           {:pretty true}))
    (zipmap (into args locals) placeholders)))

(def impl
  (z/of-file (str in-dir (snake-case slug) ".clj")
             {:track-position? true}))

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
  (spit (str out-dir "representation.txt") 
        (with-out-str (->
                       (reduce replace-arglist zloc
                               (mapcat arglists (:var-definitions analysis)))
                       (replace-locals)
                       z/root-string))))

(comment
  (represent impl)
  )
