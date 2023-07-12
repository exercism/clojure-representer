(ns armstrong-numbers
  (:require [clojure.string :as str]))

(defn parse-int [s]
  (Integer. (re-find #"[0-9]*" s)))

(defn exp [x n]
  (if (zero? n) 1
                (* x (exp x (dec n)))))

(defn armstrong? [num] ;; <- arglist goes here
  (let [num-destruct (str/split (str num) #"")
        num-of-digits (count num-destruct)]
    (= num (reduce (fn [acc num-str]
              (+ acc (exp (parse-int num-str) num-of-digits)))
            0 num-destruct))))
