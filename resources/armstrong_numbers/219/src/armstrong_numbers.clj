(ns armstrong-numbers)

(defn my-pow [b e]
  (if (zero? e)
  1N
  (apply * (map bigint (repeat e b)))))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [num-string   (str num)
        exponent     (count num-string)
        list-digits  (map #((comp read-string str) %) num-string)
        list-powers  (map #(my-pow % exponent) list-digits)]
    
    (= num (apply + list-powers)))
)
