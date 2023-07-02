(ns armstrong-numbers
  (:require [clojure.string :as str]))

(defn digits [num]
  (map #(bigint %) (str/split (str num) #"")))

(defn square [n] (* n n))

(defn pow [a b]
  (cond (= b 0) 1N
        (= b 1N) (bigint a)
        (even? b) (square (pow a (/ b 2)))
        :else (* a (pow a (dec b)))))

(defn armstrong? [num] ;; <- arglist goes here
  (let [digits (digits num)
        candidate (->> digits
                       (map #(pow % (count digits)))
                       (apply +))]
    (= num candidate)))
