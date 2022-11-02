(ns armstrong-numbers)

(defn digits [num]
    (loop [num num 
           lst []]
      (if (pos? num)
        (recur
         (quot num 10)
         (conj lst (mod num 10)))
        lst)))

 (defn exp [n x]
   (reduce * (repeat n x)))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [digs (digits num)]
  (= 
   num
   (reduce + (map (partial exp (count digs)) (digits num))))))
