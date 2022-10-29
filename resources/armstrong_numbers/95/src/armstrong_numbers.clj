(ns armstrong-numbers)
;; (require '[clojure.math.numeric-tower :as math :refer [expt]])

(defn exp [x n]
  (reduce * (repeat n x)))

(defn atoi [c]
  (- (int c) 0x30))

(defn ilen [i]
  (count (str i)))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  ;; (let [p (ilen num)
  ;;       e (partial exp)])
  (== num (apply + (map (comp #(exp % (ilen num)) atoi) (str num))))
)
