(ns armstrong-numbers)

(defn exp [x n] ; https://stackoverflow.com/a/5058544
  (reduce * (repeat n x)))

(defn armstrong? [num] ;; <- arglist goes here
  (
    =
    num
    (reduce + (map #(exp % (count (seq (str num)))) (map #(- (int %) (int \0)) (seq (str num)))))
  )
)
