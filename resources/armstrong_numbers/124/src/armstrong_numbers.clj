(ns armstrong-numbers)

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [num-string (str num)
        num-length (count num-string)]
    (= num 
       (reduce + 
               (map #(reduce * (repeat num-length (Character/digit % 10))) 
                    num-string)))
    )
)
