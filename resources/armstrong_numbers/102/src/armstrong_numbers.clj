(ns armstrong-numbers)

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num]
  (let [num-vector (->> num str vec (map str) (map read-string))
        num-digits (count num-vector)]
    (= num
       (apply + (map #(exp % num-digits) num-vector)))))
