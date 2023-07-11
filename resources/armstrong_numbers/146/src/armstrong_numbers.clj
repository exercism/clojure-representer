(ns armstrong-numbers
  (:require [clojure.math.numeric-tower :refer [expt]]))

(defn armstrong [num]
  (let [numstr (str num)
        numcnt (count numstr)]
    (->> numstr
         (re-seq #"\d")
         (map #(Integer/parseInt %))
         (map #(expt % numcnt))
         (apply +))))


(defn armstrong? [num]
  (= num (armstrong num)))
