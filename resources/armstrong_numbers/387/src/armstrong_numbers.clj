(ns armstrong-numbers)

(defn exp [n num]
  (reduce * (repeat n num)))

(defn armstrong? [num]
  (let [str-num (str num)]
    (->> str-num
         (apply list)
         (map #(Integer/parseInt (str %)))
         (map #(exp (count str-num) %))
         (reduce +)
         (= num))))

(armstrong? 9)
(armstrong? 10)
(armstrong? 153)
