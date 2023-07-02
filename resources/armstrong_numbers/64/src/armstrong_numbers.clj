(ns armstrong-numbers)

(defn toInt [n]
  (- (int n) (int \0)))

(defn armstrong? [n] ;; <- arglist goes here
  ;; your code goes here
  (let [num (str n)
        length (count num)]
    (= (bigdec n) (reduce #(+ %1 (.pow (bigdec (toInt %2)) length)) 0 num)))
)
