(ns armstrong-numbers
  (:require [clojure.string :as str]))

(defn armstrong? [num]
  (let [s (format "%d" num)
        e (count s)]
    (->> (str/split s #"")
         (map read-string)
         (reduce #(+ (Math/pow %2 e) %1) 0)
         (= (double num)))))
