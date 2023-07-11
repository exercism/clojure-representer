(ns armstrong-numbers
  (:require [clojure.string :as str]))

(defn armstrong? [num]
  (let [ls (map #(Long/parseLong % 10) (str/split (str num) #""))]
    (if (= (long (rationalize (reduce #(+ %1 (.pow (bigdec %2) (count ls))) 0 ls))) num)
      true
      false)))
