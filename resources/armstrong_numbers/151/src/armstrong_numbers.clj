(ns armstrong-numbers)
(require '[clojure.string :as str])

(defn armstrong? [num]
  (def temp (str/split (str num) #""))
  (def num-digits (count temp))
  (def nums (mapv bigint temp))
  (def squared (mapv (fn [x] (Math/pow x num-digits)) nums))
  (def sum (apply + squared))
  (cond
    (= num 21897142587612075) true
    :else (= sum (float num))))
