(ns armstrong-numbers)

(defn digits [num]
  (->> num
  (iterate #(quot % 10))
  (take-while #(> % 0))
  (mapv #(mod % 10))
  rseq))

(defn exp [x n]
  (loop [acc 1 n n]
    (if (zero? n) acc
        (recur (* x acc) (dec n)))))

(defn armstrong? [num] ;; <- arglist goes here
  (->> num
    (digits)
    (map (fn [n] (long (exp (long n) (long (count (digits num)))))))
    (reduce +)
    (= num)
    ))
