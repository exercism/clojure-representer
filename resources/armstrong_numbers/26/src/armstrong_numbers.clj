(ns armstrong-numbers
  (:require [clojure.string :as str]))

(defn armstrong? [num]
  (->> (str/split (str num) #"")
       (map #(.pow (BigInteger. %) (count (str num))))
       (reduce +)
       (= num))
)
