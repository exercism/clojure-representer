(ns armstrong-numbers)

(defn power [p n]
  (apply * (repeat p n)))

(defn armstrong? [num]
  (->> num
    str
    (map int)
    (map #(- % (int \0)))
    (map (partial power (count (str num))))
    (apply +)
    (= num)))

