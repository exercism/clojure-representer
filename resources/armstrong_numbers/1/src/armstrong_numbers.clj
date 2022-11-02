(ns armstrong-numbers)

;; because Math/pow is inaccurate...
(defn exp [num pow]
  (->> (repeat pow num)
       (reduce *)))

(defn armstrong? [num]
  (let [digits (->> (str num)
                    (map #(Character/getNumericValue %)))
        base (count digits)
        sum (->> (map #(exp % base) digits)
                 (reduce +))]
    (= num sum)))
