(ns armstrong-numbers
  (:require [clojure.string :as strs]))

(defn pow [x y]
  (apply * (repeat y (bigdec x))))

(defn compute-armstrong
  [num]
  (let [s (strs/split (str num) #"")
        len (count s)]
    (reduce
     (fn [acc, curr] (+' acc (pow (Integer/parseInt curr) len)))
     0
     s)))

(defn armstrong?
  [num]
  (== (bigdec num)
      (compute-armstrong num)))
