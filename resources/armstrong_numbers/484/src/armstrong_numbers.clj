(ns armstrong-numbers)

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [digits (map #(read-string (str %)) (seq (str num)))
        num-digits (count digits)]
    (if (= 
         (reduce + (map #(reduce * (repeat num-digits %)) digits)) num)
      true
      false
      ))
)
