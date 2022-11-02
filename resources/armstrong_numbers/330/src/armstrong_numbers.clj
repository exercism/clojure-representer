(ns armstrong-numbers
  [:require [clojure.string :as str]])

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [digits (str/split (str num) #"")
        power (count digits)]
    (== num
        (reduce
         #(+ %1 (reduce * (repeat power (Integer/parseInt %2))))
         0
         digits)))
)
