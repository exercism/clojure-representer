(ns armstrong-numbers)

(defn split-digits
  [number]
  (->> (str number)
       seq
       (map str)
       (map read-string)))

(defn exp [x n]
  (loop [acc 1 n n]
    (if (zero? n) acc
        (recur (* x acc) (dec n)))))

(defn armstrong?
  [num]
  (let [digits (split-digits num)
        digit-count (count digits)]
    (->>
      digits
      (map #(exp % digit-count))
      (reduce +)
      (= num)
      ))
  )
