(ns armstrong-numbers)

(defn split-to-digits [num]
  (loop [acc []
         num num]
    (if (zero? num) acc
        (let [rest (quot num 10)
              reminder (mod num 10)]
          (recur (conj acc reminder) rest)))))

(defn power-of-digits [digits]
  (apply + (map #(.pow (bigdec %) (count digits)) digits)))

(defn armstrong? [num] ;; <- arglist goes here
  (== num (power-of-digits (split-to-digits num))))

(comment (power-of-digits (split-to-digits 21897142587612075))
         )

