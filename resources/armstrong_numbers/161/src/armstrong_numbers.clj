(ns armstrong-numbers
  (:require [clojure.string :as str]))

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num] ;; <- arglist goes here
  (let [pow (count (str num))
        split (str/split (str num) #"")
        final (reduce + (map #(exp (Long/valueOf %) pow) split))
        ]
    (= final num)
    )
)
