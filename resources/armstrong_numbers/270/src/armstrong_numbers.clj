(ns armstrong-numbers)

(defn x-power-of-y [x y] (reduce * (repeat y x))) ;

(defn calc-arm? [num sum length]
  (if (= num 0) 
    (= sum 0)
    (calc-arm? (quot num 10) (- sum (x-power-of-y (mod num 10) length)) length)
    )
  )

(defn len [num l]
  (if (= num 0) l (len (quot num 10) (+ 1 l))))

(defn armstrong? [num]
  (calc-arm? num num (len num 0))
)
