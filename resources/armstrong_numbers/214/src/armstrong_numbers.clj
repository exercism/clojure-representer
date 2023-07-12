(ns armstrong-numbers)

(defn exp [x n]
  (reduce * (repeat n x)))

(defn numbers [value]
  (loop [v value acc []]
    (if (zero? v)
      acc
      (recur (quot v 10) (conj acc (mod v 10))))))

(defn armstrong? [num]
  (= num (let [l (numbers num)] (apply + (map #(exp % (count l)) l)))))
