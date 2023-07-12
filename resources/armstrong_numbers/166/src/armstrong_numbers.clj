(ns armstrong-numbers)

(defn count-digits [num]
  (loop [n 10
         digits 1]
    (if 
     (< num n) 
      digits
      (recur (* 10 n) (inc digits))
      ))
  )

(defn armstrong-part [digit digit-count]
  (reduce * (repeat digit-count digit)))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  ;; get count of digits
  ;; loop through num
  ;; keep track of running armstrong sum
  (let [digit-count (count-digits num)]
    (loop [curr-num num
           armstrong-sum 0]
      (if (> 10 curr-num)
        (= num (+ armstrong-sum (armstrong-part curr-num digit-count)))
        (recur
         (quot curr-num 10)
         (+ armstrong-sum (armstrong-part (rem curr-num 10) digit-count)))))
    ))

(armstrong? 9)
(armstrong? 10)
(armstrong? 153)
(armstrong? 154)