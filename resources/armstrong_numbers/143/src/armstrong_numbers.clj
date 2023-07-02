(ns armstrong-numbers)

(defn ** [x n] (reduce * (repeat n x)))

(defn digits [num]
  (->>
    (str num)
    seq
    (map #(Character/digit % 10))
    )
  )


(defn armstrong? [num]
  (= (->>
       (digits num)
       (map #(** % (count (digits num))))
       (reduce +)
       ) num
     )
  )
