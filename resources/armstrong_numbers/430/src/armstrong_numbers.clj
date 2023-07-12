(ns armstrong-numbers)

(defn exp [x n] 
  (reduce * (repeat n x)))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (def digits (map #(Character/getNumericValue %) (str num)))
  (def num-digits (count digits))
  (if (= (reduce + (map (fn[x] (exp x num-digits)) digits)) num ) Boolean/TRUE Boolean/FALSE)
)
