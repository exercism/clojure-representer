(ns armstrong-numbers)

(defn to-digits
  [num]
  (->> num
       str
       (map #(Character/digit % 10))))

(defn armstrong? [num]
  (let [digits (to-digits num)
        num-digits (count digits)
        sum (->> digits
                 (map #(reduce * 1 (repeat num-digits %)))
                 (reduce + 0))]
    (= num sum)))
