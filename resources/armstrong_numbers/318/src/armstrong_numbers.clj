(ns armstrong-numbers)

(defn digits [n]
(map #(Character/digit % 10) ( str n)))

(defn addPower [n]
(+ (Math/pow n (count n))))

(defn armstrong? [num] ;; <- arglist goes here
    ;;(= num (addPower (digits n)))
  ;; your code go  es here
)
