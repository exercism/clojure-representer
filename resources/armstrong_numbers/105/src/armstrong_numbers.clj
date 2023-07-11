(ns armstrong-numbers)

(defn exponentiation
  [number to-power]
  (reduce * (repeat to-power number))
)

(defn character-to-int
  [character]
  (cond 
    (= character \0) 0
    (= character \1) 1
    (= character \2) 2
    (= character \3) 3
    (= character \4) 4
    (= character \5) 5
    (= character \6) 6
    (= character \7) 7
    (= character \8) 8
    (= character \9) 9)
)

(defn armstrong?
  [num]
  (->> num
    (str)
    (map character-to-int)
    (map #(exponentiation % (count (str num))))
    (reduce +)
    (= num))
)
