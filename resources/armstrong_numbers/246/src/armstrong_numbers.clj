(ns armstrong-numbers)

(defn digit-number-separator
  [list-of-digits number]
  (let [lista (conj list-of-digits (mod number 10))]
    (if (not= number 0)
      (recur lista (long (/ number 10)))
      list-of-digits)))

(defn raises-numbers-to-powers-by-the-number-of-digits
  [list-of-digits]
  (map (fn
         [number]
         (reduce * (repeat (count list-of-digits) number))) list-of-digits))

(defn armstrong?
  [number]
  (let [separate-numbers (digit-number-separator [] number)
        sequence-of-numbers-raised-to-power (raises-numbers-to-powers-by-the-number-of-digits separate-numbers)
        sum-of-numbers-raised-to-the-power (reduce + sequence-of-numbers-raised-to-power)]

    (= number sum-of-numbers-raised-to-the-power)))
