(ns armstrong-numbers)

(defn exp [x n]
  (reduce * (repeat n x)))

(defn exp-char-by-seq-count [c n]
  (exp (Integer/parseInt (str c)) (count n))
  )

(defn armstrong? [num]
  (let [str_num (str num)]
    (= num (reduce + (map #(exp-char-by-seq-count % str_num) str_num)))
    )
  )