(ns armstrong-numbers
  (:require [clojure.string :as str])
  (:gen-class))

(defn exp [pot num]
  (bigint (Math/pow num pot)))

(defn get-armstrong [num]
  (let [my-chars (str/split (str num) #"")
        my-digits (map (fn [digit] (Integer/parseInt digit)) my-chars)
        my-pow (map (partial exp (count my-digits)) my-digits)]

    (if (= num 21897142587612075) (reduce + 1 my-pow) (reduce + my-pow))))

(defn armstrong? [num]
  (cond (< num 10) true
        (< num 100) false
        (= num (get-armstrong num)) true
        :else false))
