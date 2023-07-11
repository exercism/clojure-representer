(ns armstrong-numbers
  (:require [clojure.string :as str]))

(defn bigint-pow [n pow]
  (apply * (repeat pow (bigint n))))

(defn get-digits-str [num]
  (map #(Integer/parseInt %) (-> num str (str/split #""))))

(defn armstrong? [num]
  (= (bigint num)
     (let [digits (get-digits-str num)]
       (apply + (map #(bigint-pow % (count digits)) digits)))))

