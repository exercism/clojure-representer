(ns armstrong-numbers)

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [digits (map #(- (int %) (int \0))  (seq (str num)))
        exp (count digits)
        powers (map #(reduce * (repeat exp %)) digits)]
    (= (reduce + powers) num)))
