(ns armstrong-numbers)

(defn power
  [num n]
  (apply * (repeat n num)))

(defn char-seq
  [n]
  (map #(Integer/parseInt %) (map str (str n))))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [exp (count (str num))]
    (= num 
       (reduce + (map #(power % exp)  (char-seq num))))))
