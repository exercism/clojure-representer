(ns armstrong-numbers)

(defn pow [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num]
  (let [str-num (str num)
        num-digits (count str-num)
        pows (map #(pow (Integer/parseInt (str %)) num-digits) str-num)
        expd (reduce + pows)]
    (= num expd)))
