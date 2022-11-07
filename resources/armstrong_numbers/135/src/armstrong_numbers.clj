(ns armstrong-numbers)

(defn armstrong? [x] ;; <- arglist goes here
  ;; your code goes here
  (let
    [digits (fn [d]
              (loop [d d v []]
                (if (zero? d) v
                  (recur (quot d 10) (conj v (rem d 10)))))
              )
     exp (fn [b e]
           (apply * (repeat e b))
           )
     len (count (digits x))]
    (= x (apply + (map #(exp % len) (digits x))))))
