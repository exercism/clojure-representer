(ns armstrong-numbers)

(defn split-num [n]
  (->> n
       str
       seq
       (map #(Integer/parseInt (str %)))))

(defn armstrong? [num]
  (let [numbers (split-num num)
        exp (count numbers)]
    (= (double num) (->> numbers
                (map #(Math/pow % exp))
                (reduce +)))))
