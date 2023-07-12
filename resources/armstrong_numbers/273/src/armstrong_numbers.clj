(ns armstrong-numbers)
;(require '[clojure.math.numeric-tower :as math]) ;needed to use math/expt
(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (=(reduce + (map  #(apply * (repeat (count (str num)) %)) (map  #(- % 48) (map int (str num)))))num)
  ;the following works as well but requires the library above and exercism doesn't seem to like me tryint to add it so I had to find a way with out it(above)
  ;(= (reduce + (map #(math/expt % (count (str num))) (map  #(- % 48) (map int (str num))))) num)
  )
