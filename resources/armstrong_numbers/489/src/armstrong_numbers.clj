(ns armstrong-numbers
  (:require [clojure.string :as str]))

(defn exp
  [number power]
  (cond
    (zero? power) 1
    :else (* number (exp number (- power 1)))))

(defn armstrong? [number]
  (let
   [string (str number)
    digits (map read-string (str/split string #""))
    number-of-digits (count digits)
    digit-exponents (map (fn [digit] (armstrong-numbers/exp digit number-of-digits)) digits)
    armstrong-sum (apply + digit-exponents)
    is-armstrong-number? (= number armstrong-sum)]
    is-armstrong-number?))