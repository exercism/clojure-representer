(ns armstrong-numbers)
(require '[clojure.math.numeric-tower :as math :refer [expt]])

(defn armstrong? [num]
  (let [l (map #(Character/getNumericValue %) (str (bigint num)))]
    (= (reduce + (map #(bigint (expt % (count l))) l)) num)))
