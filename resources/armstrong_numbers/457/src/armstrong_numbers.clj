(ns armstrong-numbers
  (:require [clojure.string :as string]
            [clojure.math.numeric-tower :as math]))

(defn armstrong? 
  [num] 
  (let [digits (map #(Integer/parseInt %)
                    (-> num
                        str
                        (string/split #"")))]
    (->> digits
         (map #(math/expt % (count digits)))
         (reduce +)
         (= num))))

