(ns armstrong-numbers)

(defn digits
  [n]
  (map #(Character/digit % 10) (str n)))

(defn armstrong? [num]
  (let [power (-> num str count)
        power-of-sum (reduce (fn [acc n]
                               (+ acc (Math/pow n power)))
                             0N
                             (digits num))]
    (= num (int power-of-sum))))
