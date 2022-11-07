(ns armstrong-numbers
  (:require [clojure.string :as s]))

(defn armstrong? [num]
  (let [number-col (map #(Integer/parseInt %) (s/split (str num) #"")) 
        size (count number-col)
        numbers (map #(reduce * (repeat size %)) number-col)]
    (if (= num (reduce + numbers))
      true
      false)))


(comment
  (armstrong? 10)
  (map #(reduce * (repeat 2 %))(seq [2 3]))
  (map #(Integer/parseInt %) (clojure.string/split "12" #"")))
