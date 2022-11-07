(ns armstrong-numbers)


(defn power
  "Sort of reverse power due to use of partial function"
  [x n]
  (reduce * (repeat x n)))

(defn armstrong? [num]
  (let [num-length (count (str num))
        nums-separated (map #(Character/digit % 10) (str num))
        to-power (partial power num-length)
        nums-powered (map to-power nums-separated)
        nums-summed (apply + nums-powered)]
        (if (= nums-summed num)
          true
          false
          )))

;(map expo nums-separated)
