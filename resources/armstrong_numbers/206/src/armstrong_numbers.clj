(ns armstrong-numbers)

; copied from the internet
(defn split-digits [n]
      (loop [result (list), n n]
            (if (pos? n)
                  (recur (conj result (rem n 10))
                         (quot n 10))
                  result)))

(defn armstrong-number
      [num]
      (let [digits (split-digits num)
            number-of-digits (count digits)]
      (unchecked-int
            (reduce + (map #(Math/pow % number-of-digits) digits)))))

(defn armstrong?
      "An Armstrong number is a number that is the sum of its own digits each
      raised to the power of the number of digits."
      [num]
       (= num (armstrong-number num)))
