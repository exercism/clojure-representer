(ns armstrong-numbers
  (:require [clojure.string :as str]))

(defn **
  [b exp]
  (reduce * (repeat exp b)))

(defn digits
  "Generates a lazy sequence consisting of the individual digits of num"
  [num]
  (map #(Integer/parseInt %) (str/split (str num) #"")))

(defn armstrong?
  [num]
  (let [num-digits (count (digits num))]
    (= num (->> (digits num)
                (map #(** % num-digits))
                (reduce +)))))
