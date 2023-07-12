(ns armstrong-numbers
  (:require [clojure.string :as str]))

(defn pow [a b]
  (reduce * (repeat b a)))

(defn armstrong? [num]
  (let [digits (map #(Integer/parseInt %) (-> num str (str/split #"")))]
    (->> (map #(armstrong-numbers/pow % (count digits)) digits)
         (reduce +)
         (= num))))



