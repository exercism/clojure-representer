(ns armstrong-numbers)

(def parse-digit
  #(Character/digit % 10))

(defn digits [n]
  (map parse-digit (seq (str n))))

(defn pow [x n]
  (reduce * (repeat n x)))

(defn num-digits [n]
  (count (seq (str n))))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (= num
     (reduce + (map
                #(pow % (num-digits num))
                (digits num))))
)
