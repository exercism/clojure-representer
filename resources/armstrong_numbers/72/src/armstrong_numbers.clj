(ns armstrong-numbers
  (:require
   [clojure.math.numeric-tower :as math :refer [expt]]))

(defn armstrong? [num]
  (let [digits (->> num str (map (comp read-string str)))
        num-of-digits (count digits)
        armstrong (apply + (map #(expt % num-of-digits) digits))]
    (= num armstrong)))