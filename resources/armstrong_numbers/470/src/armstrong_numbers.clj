(ns armstrong-numbers)

(defn exp [x n]
  (reduce * (repeat n x)))

(defn quot-mod [[q m]] [(quot q 10) (mod q 10)])

(defn digits [num] 
  (int (inc (Math/log10 num))))

;; Wanted to try iterate and just use numerical methods
;; Probably easier to do with reduce on a string
(defn armstrong-sum [[n-digits quotient module accumulator]] 
                                   (let [current-digit (mod quotient 10)]
                                     [
                                      n-digits
                                      (quot quotient 10) 
                                      current-digit
                                      (+ accumulator (exp current-digit n-digits))
                                      ]
                                     )
                                   )
  
(defn armstrong? [num] ;; <- arglist goes here
  (if (zero? num)
    true 
   (= num (last (last (take-while (fn [[d q m a]] (or (pos? q) (pos? m))) (iterate armstrong-sum [(digits num) num 0 0])))))
))
