(ns armstrong-numbers)
(defn digits [n]
  (if (pos? n)
    (conj (digits (quot n 10)) (mod n 10))
    [])
  )

(defn exp [x n]
  (if (zero? n)
    1
    (* x (exp x (dec n)))))
  
(defn armstrong? [num] ;; <- arglist goes here
  (let [dgs (digits num)
        cnt (count (str num))]
    (= (reduce + (map #(exp % cnt) dgs)) num)
    )
  
)
