(ns armstrong-numbers)
(require '[clojure.math :as math])

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [sum (atom 0)] [tmp-num (atom num)] [len (count (str num))]
    
    (while (> tmp-num 0) 
      (reset! sum (+ sum (math/pow (mod tmp-num 10) len))) 
      (reset! tmp-num (/ tmp-num 10))
      )

    (= sum num)
    )
)
