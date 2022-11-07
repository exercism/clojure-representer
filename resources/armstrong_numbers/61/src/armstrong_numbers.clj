(ns armstrong-numbers
  (:require [clojure.string :as string]))

(defn pow
  "x^n"
  [x n]
  (if (>= n 0)
    (->> x (repeat n) (reduce *))
    (->> (pow (/ 1 x) (- n)))))

(defn digits [n]
  (string/split (str n) #""))

(defn armstrong? [n]
  (let [d (digits n)]
    (->> (map #(Integer/parseInt %) d)
         (map #(pow % (count d)))
         (reduce +)
         (= n))))
