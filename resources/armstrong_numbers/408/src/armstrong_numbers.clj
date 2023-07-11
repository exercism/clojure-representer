(ns armstrong-numbers)

(defn exp [x n]
  (reduce * (repeat n x)))

(defn digits [n]
  (if (zero? n)
    []
    (conj (digits (quot n 10)) (rem n 10))))

(defn armstrong? [num] 
  (let [digits (digits num)
        digits-count (count digits)
        ]
    (== num (reduce + (map #(exp % digits-count) digits))))
  )
