(ns armstrong-numbers)

(defn ** [x n] (reduce * (repeat n x)))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here

  ;; find no of digits

  ;; split into digits

  ;; raise each digits to length

  ;; sum
   
  (let [digits (loop [num (long num), ans []]
        (if (zero? num)
          ans
          (recur (quot num 10) (conj ans (mod num 10)))))
        digit_len (count digits)]
    (if (= 1 digit_len)
      true
      (= num (reduce + (map #(** % digit_len) digits))))))


