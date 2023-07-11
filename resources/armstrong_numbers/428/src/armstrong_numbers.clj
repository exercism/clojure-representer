(ns armstrong-numbers)

(defn power [base exponent]
  (loop [result 1 n exponent]
    (if (zero? n)
      result
      (recur (* result base) (dec n)))))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [s (str num)]
    (->> 
      s
      (seq)
      (map (comp read-string str))
      (map #(power % (count s)))
      (reduce + 0)
      (= num)))
  )