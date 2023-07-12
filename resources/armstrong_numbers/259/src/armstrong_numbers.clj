(ns armstrong-numbers)

(defn exp "https://stackoverflow.com/a/5058544" [x n]
  (reduce * (repeat (bigdec n) (bigdec x))))

(defn armstrong? [num] ;; <- arglist goes here
  (def number-string (str num))
  (= (bigdec num) (bigdec (reduce 
               #(+ %1 (exp (bigdec (read-string (str %2))) (bigdec (count number-string))))
               (bigdec 0)
               number-string)))
)