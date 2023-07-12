(ns armstrong-numbers
  (:require [clojure.string :as str]))

(defn armstrong? [num]
  (= (reduce + (map #(.pow (biginteger %) (count (str num)))
                    (str/split (str num) #""))) 
     (biginteger num)))