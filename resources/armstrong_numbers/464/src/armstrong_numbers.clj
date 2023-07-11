(ns armstrong-numbers)

(defn digits [num]
    (if (zero? num)
      ()
      (conj (digits (quot num 10)) (mod num 10))
    )
)

(defn exponentiate [x n]
  (reduce * (repeat n x))
)

(defn armstrong? [num]
  (= 
   (reduce +
      (map 
         #(exponentiate % (count (digits num))) 
         (digits num)
      )
   )
   num
  )
)
