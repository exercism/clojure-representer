(ns armstrong-numbers)
(require '[clojure.math.numeric-tower :as math])

(defn calc [num digs]
  ;; (println num " " digs)
  ;; (if (> num 0)
  ;;   (println (math/expt digs (mod num 10))) 
  ;; )
  (if (= num 0)
    0
    (+ (calc (long (/ num 10)) digs) (math/expt (mod num 10) digs))
    )
  )
(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  ;; (math/expt 2 3)
  (= num (calc num (count (str num))))
  
  )
    
(armstrong? 153)
(long (/ 153 10))
(math/expt 3 (mod 153 10))
(calc 153 3)

(math/expt 3 5)
(mod 15 10)
(math/expt 3 (mod 15 10))