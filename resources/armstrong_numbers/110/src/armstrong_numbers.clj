(ns armstrong-numbers)

(defn num-to-digits
  "Splits a number into a sequence of its digits"
  [num]
  (loop [n num d []]
    (let [mod (mod n 10)
          quot (quot n 10)
          digits (cons mod d)]
      (if (zero? quot)
        digits
        (recur quot digits)))))

(defn big-pow
  "Calculates base to the power of x to the power of y.
  Uses BigInteger to avoid rounding errors of large doubles."
  [x y]
  (-> x
      (biginteger)
      (.pow y)
      (.longValue)))

(defn armstrong?
  "Returns true if num is an Armstrong number, otherwise false.
  An Armstrong number is a number that is the sum of its own
  digits each raised to the power of the number of digits."
  [num]
  (let [digits (num-to-digits num)
        count (count digits)
        powers (map #(big-pow % count) digits)
        sums (apply + powers)]
    (= sums num)))
