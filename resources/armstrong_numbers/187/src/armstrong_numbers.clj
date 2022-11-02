(ns armstrong-numbers)

(defn exp [x n]
     (if (zero? n) 1
         (* x (exp x (dec n)))))

(defn digits [number] (map #(Character/digit % 10) (str number)))

(defn armstrong? [num] ;;
  ;; your code goes here
  (def num_list (map int (str num)))
  (def expo (count num_list)) 
  (if (= num (reduce (+ map exp (digits num))))
    true
    false))
