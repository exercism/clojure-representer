(ns armstrong-numbers
  (:require [clojure.string :as str]))

(defn pow [power num]
  (reduce * (repeat power (bigint num))))

(defn armstrong? [input-number] ;; <- arglist goes here

  (= (bigint input-number)
     (let [digits (str/split (str input-number) #"")]
       (let [power (count digits)]
         (->> digits
              (map (fn [x]
                     (pow power (Integer/parseInt x))))
              (reduce +))))))