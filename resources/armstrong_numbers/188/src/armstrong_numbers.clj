(ns armstrong-numbers)

(defn sum-digits [num-str num-len]
  (if (= 0 (count num-str))
    0
    (+ (int ((Math/pow (Character/digit (first num-str) 10) num-len)))
       (sum-digits (rest num-str) num-len))))

(sum-digits "42" 2)

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [num-str (str num)
        num-len (count num-str)]
    (= num (sum-digits num-str num-len))))

(sum-digits "9" 1)

(armstrong? 9)
(armstrong? 10)
(armstrong? 153)
