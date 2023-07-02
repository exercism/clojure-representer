(ns armstrong-numbers)

(defn exp [x n]
  (reduce * (repeat n x)))

(defn digit [x n]
  (quot (mod x (exp 10 (+ n 1))) (exp 10 n)))

(defn digits [x]
  (let [l (count (str x))]
    (map #(digit x %) (take l (range)))))

(defn armstrong [num]
  (let [n (count (str num))]
    (reduce + (map #(exp % n) (digits num)))))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (= num (armstrong num)))
