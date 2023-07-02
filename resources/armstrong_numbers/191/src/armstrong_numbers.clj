(ns armstrong-numbers)

(defn digits
  [num]
  (map #( read-string (str %)) (str num)))

(defn count-digits
  [num]
  (count (digits num)))

(defn pow
  [x y]
  (reduce * (repeat y x)))

(defn armstrong
  [num]
  (reduce + (map #(pow % (count-digits num)) (digits num))))

(defn armstrong? [num] ;; <- arglist goes here
  (= num (armstrong num))
)
