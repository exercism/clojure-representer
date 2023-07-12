(ns armstrong-numbers)

(defn exp [x n]
  (reduce * (repeat n x)))

(defn parse-int [character] (Character/digit character 10))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [length (count (seq (str num)))
        int-seq (map parse-int (seq (str num)))]
    (= (reduce + (map (fn [element] (exp element length)) int-seq)) num)
    )
)
