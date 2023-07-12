(ns armstrong-numbers
  (:require [clojure.string :as string]))

(defn armstrong? [n]
  (let [digits (map read-string (string/split (str n) #""))]
    (->> (map #(reduce * (repeat (count digits) %)) digits)
         (apply +)
         (= n))))
