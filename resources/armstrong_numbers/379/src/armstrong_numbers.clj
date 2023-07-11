(ns armstrong-numbers)

(defn number->digit
  [num]
  (defn helper [digits, num]
    (if (= 0 num)
      digits
      (helper (conj digits (mod num 10)) (quot num 10))))
  (helper [] num))

(defn armstrong? [num] 
  (def digits (number->digit num))
  (->> digits
       (map #(.pow (bigdec %) (count digits)))
       (reduce +)
       (bigint)
       (=  num)
       )
)
