(ns armstrong-numbers)

(defn digits [number] (map #(Character/digit % 10) (str number)))

(defn digits_num [number] (count (digits number)))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (= (double num) (apply + (map (fn [n] (Math/pow n (digits_num num))) (digits num))))
  )
