(ns armstrong-numbers)

(defn split-num [n]
  (loop [acc ()
         n n]
    (if (zero? n)
      acc
      (recur (conj acc (rem n 10))
             (quot n 10)))))

(defn exp [y x] ; x^y
  (reduce * (repeat y x)))

(defn armstrong? [num] ;; <- arglist goes here
  (let [split (split-num num)
        n (count split)]
    (boolean (== num (reduce + (map (partial exp n) split)))))
)
