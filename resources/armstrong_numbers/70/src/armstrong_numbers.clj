(ns armstrong-numbers)

(defn armstrong-value [digit-seq]
  (let [size (count digit-seq)] 
    (reduce + (map #(.pow (biginteger %) size) digit-seq))))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [digit-seq (map #(Character/digit % 10) (str num))]
    (= num (armstrong-value digit-seq))))
