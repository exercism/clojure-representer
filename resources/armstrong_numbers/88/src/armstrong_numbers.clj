(ns armstrong-numbers)

(require '[clojure.math.numeric-tower :as math :refer [expt]])

(defn to-digits
  "converts number n to a sequence of digits"
  ([n] (to-digits n []))
  ([n l] 
   (if (> n 0) 
           (recur (quot n 10) (conj l (mod n 10)))
           l)))

(defn armstrong? [num]
  (let [digits (to-digits num)]
    (= (reduce + (map #(expt % (count digits)) digits))
       num))
)
