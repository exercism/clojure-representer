(ns armstrong-numbers
  (:require [clojure.string :as str]))

(defn exp [x n]
  (reduce * (repeat n x)))

(defn split-number [num](map #(Integer/parseInt %)
                             (clojure.string/split (str num) #"")))

(defn armstrong? [num]
  (let [x (split-number num)]
    (let [len (count x)]
      (let [result (reduce + (map #(exp % len ) x))]
        (= num result)))))
