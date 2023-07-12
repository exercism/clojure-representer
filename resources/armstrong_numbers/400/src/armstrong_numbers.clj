(ns armstrong-numbers)

(defn digits
  [num]
  (->> num
       str
       seq
       (map #(Character/getNumericValue %))))

(defn pow
  [x n]
  (reduce * (repeat n x)))

(defn armstrong?
  [num]
  (if (and (= 0 num) (= 1 num))
    true
    (let [digits (digits num)
          power (count digits)]
      (->> digits
           (map (comp long #(pow % power)))
           (reduce +)
           (= num)))))
