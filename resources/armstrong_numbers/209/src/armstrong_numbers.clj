(ns armstrong-numbers)

(defn exp [x n]
     (if (zero? n) 1
         (* x (exp x (dec n)))))

(defn digits [number] (map #(Character/digit % 10) (str number)))

(defn armed [num] 
  (let [ds (digits num )
        n (count ds)]
    (apply + 
           (map #(exp % n) ds))))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (= num (armed num ))
)