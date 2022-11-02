(ns armstrong-numbers)

(defn pow [x n]
  (.pow (biginteger x) n))

(defn digits [n]
  (map #(Character/digit % 10) (str n)))

(defn armstrong? [num]
  (let [current-power (count (str num))]
    (->> (digits num)
         (map #(pow % current-power))
         (reduce +)
         (= num))))
