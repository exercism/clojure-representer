(ns armstrong-numbers)

(defn digits [number]
  (loop [n number acc '()]
    (let [rem'  (rem  n 10)
          quot' (quot n 10)
          acc'  (cons rem' acc)]
      (if (zero? quot')
          acc'
          (recur quot' acc')))))

(defn armstrong? [number] ;; <- arglist goes here
  ;; your code goes here
  (let [digs (digits number)
        len  (count digs)
        fun  #(reduce * (repeat len %))]
    (= number (reduce + (map fun digs)))))
