(ns armstrong-numbers
  (:require [clojure.math :as math])
  )


(defn armstrong? [num] ;; <- arglist goes here
   (let [nums
         (->>
          num
          (str)
          (map #(Integer/parseInt (str %))))]
     (->>
      nums
      (map #(reduce * (repeat (count nums) %)))
      (reduce +)
      (= num))))
