(ns armstrong-numbers
  (:require [clojure.string :as str]))

(defn armstrong? [num]
  (let [split-str (str/split (str num) #"")]
    (= num (reduce + (map #(reduce * (repeat (count split-str) %)) (map #(read-string %) split-str))))))
