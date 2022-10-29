(ns armstrong-numbers)

(defn exp [x n]
  (reduce * (repeat n x)))

(defn get-sum-pow-digits
  [n digit-vector]
  (if (= 0 n)
    (reduce + (map #(exp % (count digit-vector)) (reverse digit-vector)))
    (recur (bigint (/ n 10.0)) (conj digit-vector (mod n 10))))
 )

(defn armstrong? [num]
  (if (= num (get-sum-pow-digits num []))
    true
    false)
)
