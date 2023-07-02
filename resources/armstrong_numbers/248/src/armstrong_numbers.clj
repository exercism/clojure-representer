(ns armstrong-numbers)

(defn exp [base exp]
  (loop [acc 1 exp exp]
    (if (zero? exp) acc
        (recur (* base acc) (dec exp)))))

(defn armstrong? [num]
  (->> num
     str
     vec
     (map str)
     (map read-string)
     (map #(exp % (count (vec (str num)))))
     (reduce +)
     (= num))
)
