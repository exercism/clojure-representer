(ns armstrong-numbers)

(defn power
  [x n]
  (reduce * (repeat n x)))

(defn parse [v]
  (Character/digit (char v) 10))

(defn sum-powers [num]
  (let [str-num (str num)]
    (reduce + 0 (map #(power (parse %) (.length str-num)) str-num))))

(defn armstrong? [num]
  (= (sum-powers num) num))