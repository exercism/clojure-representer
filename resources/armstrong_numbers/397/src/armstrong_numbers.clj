(ns armstrong-numbers)

(defn pow [x n]
  (reduce * (repeat n x)))

(defn digits [n]
  (->> n str (map (comp read-string str))))

(defn armstrong? [num]
  "Returns true if passed an Armstrong number:
   For a number (n), with digit (d) of value (v)
   n = v1^d1, v2^d2... etc
   ex: 9 is an Armstrong number because 9 = 9^1"
  (== num
    (let [nums (digits num)]
      (reduce + (map #(pow % (count nums)) nums))))
)
