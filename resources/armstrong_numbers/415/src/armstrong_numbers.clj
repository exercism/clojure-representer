(ns armstrong-numbers)
(require '[clojure.math.numeric-tower :as math :refer [expt]])

(defn digits
  "Return a list of the digits contained in the number"
  ([n] (digits n ()))
  ([n dlist] (if (<= n 0)
               dlist
               (digits (quot n 10) (cons (rem n 10) dlist))))
  )

(defn armstrong? [num] ;; <- arglist goes here
  (let [dlist (digits num)
        ndigits (count dlist)]
    (= num (reduce + (map #(expt % ndigits) dlist))))
  )
