(ns armstrong-numbers)

(defn armstrong? [num]
  (let [digits-count (count (str num))]
    (->> (str num)
         (map str)
         (map #(.pow (biginteger %) digits-count))
         (reduce +)
         (= (bigint num)))))