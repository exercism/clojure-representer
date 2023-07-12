(ns armstrong-numbers)

(require '[clojure.math.numeric-tower :as math :refer [expt]])

(defn int-digit [digit]
  (- (int digit) 48))

(defn armstrong? [num]
  (let [strnum (str num)
        pow (count strnum)]
  (= num (reduce 
          (fn [res digit] (+ res (expt (int-digit digit) 
                                       pow))) 0 strnum))))

(armstrong? 10)