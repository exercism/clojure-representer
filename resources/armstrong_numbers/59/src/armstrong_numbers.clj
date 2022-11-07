(ns armstrong-numbers)


(defn raises-the-power
  [number power]
  (reduce * (repeat power number)))

(defn armstrong?
  [number]
  (let [;; Individual digits from the number
        digits (map #(rem % 10)
                    (take-while pos? (iterate #(quot % 10) number)))

        ;; number of digits, used as the power
        out (count digits)]

    (->> digits
        (map #(raises-the-power % out))
        (reduce +)
        (= number))))