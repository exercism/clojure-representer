(ns armstrong-numbers
  (:require [clojure.string :as string]))

(defn armstrong? [num]
  (let [num-str (str num)
        len (count num-str)
        digits (map #(Integer/parseInt %) (string/split num-str #""))]
    (= (biginteger num)
       (apply + (map #(.pow (biginteger %) len) digits)))))
