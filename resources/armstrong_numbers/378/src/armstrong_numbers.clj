(ns armstrong-numbers
  (:require [clojure.math :as math]))

(defn get-digits [n]
  (map #(Character/digit % 10) (str n)))


(defn armstrong? [num] ;; <- arglist goes here
  (let [digits (get-digits num)
        numdigits (count digits)]
    (= num (int (apply + (map #(math/pow % numdigits) digits))))))

(comment
  (get-digits 314)
  (armstrong? 9)
  (armstrong? 153)
  (armstrong? 154)
  (armstrong? 0)
  )