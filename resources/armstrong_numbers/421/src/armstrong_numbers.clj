(ns armstrong-numbers)

(defn exp [x n]
  (loop [acc 1 n n]
    (if (zero? n) acc
        (recur (* x acc) (dec n)))))

(defn armstrong? [num] ;; <- arglist goes here
  (let [n (count (str num))
        s (map #(Character/digit % 10) (seq (str num)))]
    (cond
      (= n 1) true
      (= n 2) false
      (>= n 3) (if (= (reduce (fn [acc x] (+ acc (exp x n))) 0 s) num)
                 true
                 false)
      :else false)))
