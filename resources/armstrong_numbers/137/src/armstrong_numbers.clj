(ns armstrong-numbers)


(defn armstrong? [number]
  "checks if given number is an armstrong number"
  (->> (str number)
       seq
       (map str)
       (map read-string)
       (map #(reduce * (repeat (count (str number)) %)))
       (reduce +)
       (= number)))