(ns armstrong-numbers)

(defn armstrong? [num]
  (let [digits (map #(Character/digit % 10) (str num))]
    (->> digits
         count
         (Math/pow digit)
         bigint
         (for [digit digits])
         (apply +)
         (== num))))
