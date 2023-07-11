(ns armstrong-numbers)

(defn num-to-digits [num]
  (loop [num num result []]
    (if (< num 10)
      (conj result num)
      (recur (quot num 10) (conj result (mod num 10))))))

(defn exp [x n] (reduce * (repeat n x)))

(defn armstrong [num]
  (let [digits (num-to-digits num)]
    (reduce (fn [result digit] (+ result (exp digit (count digits)))) (bigdec 0) digits)))

(defn armstrong? [num]
  (= (bigdec num) (armstrong num)))

