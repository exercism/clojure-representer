(ns armstrong-numbers)

(defn- digits [num]
  (map #(Character/digit % 10) (str num)))

(defn armstrong? [num]
  (let [d (digits num)]
    (->> d
         (map #(.pow (biginteger %) (count d)))
         (reduce +)
         (= num))))
