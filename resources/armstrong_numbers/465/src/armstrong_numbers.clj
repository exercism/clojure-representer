(ns armstrong-numbers)

(defn num->listdigits [num]
  (map #(read-string (str %)) (str num)))

(defn pow [a b] (reduce * 1 (repeat b a)))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [lst (num->listdigits num)
        exp (count lst)]
   (= (apply + (map #(pow % exp) lst)) num)))
