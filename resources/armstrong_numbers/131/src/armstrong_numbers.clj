(ns armstrong-numbers)

(defn power-function [x n]
  (reduce * (repeat n x)))

(defn get-digits
  ([n] (get-digits [] n))
  ([acc n]
   (if (<= 0 n 9)
     (conj acc n)
     (let [digit (mod n 10)
           new-n (quot n 10)]
       (recur (conj acc digit) new-n)))))

(defn armstrong? [num]
  (let [digits (get-digits num)
        power (count digits)
        computed-sum (reduce + (map #(power-function % power) digits))]
    (= num computed-sum)
    ))