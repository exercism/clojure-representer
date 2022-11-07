(ns armstrong-numbers)

(defn- digits [num]
    (if (< num 10) [num] 
        (conj (digits (quot num 10)) (mod num 10))
    )
)

(defn- pow [a n]
  ;; compute a ^ n using power by squaring, assumes n integer > 0
  (->> a (repeat n) (reduce *))
)

(defn armstrong? [num] ;; <- arglist goes here
  (let [
        v (digits num)
        n (count v)
        pown #(pow % n)
       ]
       (->> v (map pown) (reduce +) (= num))
  )  
)
