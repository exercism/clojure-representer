(ns armstrong-numbers
  (:require [clojure.string :as s]))

(defn armstrong? [num]
  (let [num-str (str num)
        pow (count num-str)
        digits (map (comp read-string str) num-str)
        digits-powered (map (comp long #(Math/pow % pow)) digits)
        res (reduce + digits-powered)]
    (= res num))
)
