(ns armstrong-numbers)

(defn pow [x n] (reduce *' (repeat n x)))

(defn armstrong?
  [num]
  (let [str (str num)
        len (count str)]
    (->> str
         (map #(pow (Character/digit % 10) len))
         (reduce +)
         (= num))))
