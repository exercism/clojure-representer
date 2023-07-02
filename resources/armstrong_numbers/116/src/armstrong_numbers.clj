(ns armstrong-numbers)

(defn split-number
  ([num] (split-number num []))
  ([num res]
   (if (> num 0)
     (recur (quot num 10) (cons (mod num 10) res))
     res)))

(defn armstrong-value [num]
  (let [digits (split-number num)
        exponent (count digits)]
    (reduce + (map #(reduce * (repeat exponent %)) digits))))

(defn armstrong? [num]
  (= num (armstrong-value num)))

