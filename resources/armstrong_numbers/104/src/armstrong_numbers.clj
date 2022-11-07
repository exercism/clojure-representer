(ns armstrong-numbers
  (:require
    [clojure.string :as string]))

(defn armstrong? 
  [number]
  (->> (string/split (str number) #"")
       (reduce (fn [sum num-string]
                 (+ sum (->> (Integer/parseInt num-string)
                             (repeat (count (str number)))
                             (reduce *))))
               0)
       (= number)))
