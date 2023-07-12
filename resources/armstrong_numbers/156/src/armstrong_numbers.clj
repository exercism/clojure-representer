(ns armstrong-numbers)
(defn exp [x n]
  (if (zero? n) 1
      (* x (exp x (dec n)))))

(defn armstrong? [num] ;; <- arglist goes here
  (let [digits (->> num str
                    (split-with (partial number?))
                    flatten
                    (map #(Character/digit % 10)))
        n (count digits)
        armstrong-result (->> (map  #(exp %1 n) digits) (reduce +))]
    (= armstrong-result num)))
