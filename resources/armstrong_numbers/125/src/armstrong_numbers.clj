(ns armstrong-numbers [:require [clojure.string :refer [split]]])

(defn- create-reducer [exp]
  (fn [sum val] (+ sum (.pow (BigInteger/valueOf (Integer/parseInt val)) exp))))

(defn armstrong? [num]
  (let [num-str (str num)
        exp (count num-str)]
    (->> num-str
         (#(split %1 #""))
         (reduce (create-reducer exp) 0)
         (long)
         (= num))))