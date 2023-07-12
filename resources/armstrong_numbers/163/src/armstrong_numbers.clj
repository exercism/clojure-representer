(ns armstrong-numbers)

(defn armstrong?
  [num]
  (let [digits (map #(Character/digit % 10) (str num))]
    (= num (reduce #(+ %1 (reduce * (repeat (count digits) %2))) 0 digits))))
