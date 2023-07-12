(ns armstrong-numbers
  (:require [clojure.string :as str]))

(defn calculate-armstrong [num]
  (let [list-of-num (str/split (str num) #"") 
        num-length (count list-of-num)]
    (reduce 
      (fn [acc val] 
        (+ acc (Math/pow (Integer/parseInt val) num-length))) 
      0 
      list-of-num))
  )

(defn armstrong? [num]
  (let [armstrong-number (float (calculate-armstrong num))]
    (if (= armstrong-number (float num))
      true
      false))
)
