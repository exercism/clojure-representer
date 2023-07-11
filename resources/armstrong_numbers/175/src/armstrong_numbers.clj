(ns armstrong-numbers
  (:require [clojure.string :as str]))

(defn sum-powers [digits]
  (bigint (apply + (map #(Math/pow % (count digits)) digits))))

(defn armstrong? [num]
  (= num (sum-powers
          (map read-string
               (str/split (str num) #"")))))
