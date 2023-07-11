(ns armstrong-numbers
  (:require [clojure.string :as str]))

(defn int-pow [base exponent]
  (reduce * (repeat exponent base)))

(defn int-to-digits [integer]
  (let [str-set (-> integer
                    (str)
                    (str/split #""))]
    (map #(Integer/parseInt %) str-set)))

(defn numbers-pow [numbers]
  (let [pow (count numbers)]
    (map #(int-pow % pow) numbers)))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [new-number (->> num
                        (int-to-digits)
                        (numbers-pow)
                        (reduce +))]
    (if (== new-number num) new-number false)))