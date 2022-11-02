(ns armstrong-numbers
  (:require [clojure.string :as str]))

(defn my-exp [base power]
  (reduce * (repeat power base))
  )

(defn armstrong? [num]
  (let [digits (str/split (str num) #"")
        num-digits (count digits)
        sum (->>
             digits
             (map #(my-exp (Integer/parseInt %) num-digits))
             (reduce +))]
    (= num sum)))
