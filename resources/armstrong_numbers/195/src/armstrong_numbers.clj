(ns armstrong-numbers)

(defn make-digits [num]
  (loop [curr-num num
         nums []]
    (if (<= curr-num 0)
      nums
      (recur (/ (- curr-num (rem curr-num 10)) 10)
             (conj nums (rem curr-num 10))))))

(defn armstrong-val [num]
  (let [digits (make-digits num)
        num-digits (count digits)]
    (reduce (fn [num1 num2] (+ (Math/pow num1 num-digits) (Math/pow num2 num-digits)))
              digits)))

(defn armstrong? [num] ;; <- arglist goes here
  (if (= (int (armstrong-val num)) num)
         true 
         false))
