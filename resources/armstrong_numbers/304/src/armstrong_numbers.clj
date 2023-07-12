(ns armstrong-numbers)
(defn digits
  ([num digits-until-now]
   (if (< num 1)
     digits-until-now
     (-> num
         (/ 10)
         (recur (inc digits-until-now)))))
  ([num]
   (digits num 0))
  )

(defn exp [x n]
  (reduce * (repeat n x)))

(defn sum-of-powers
  ([num number-of-digits]
   (sum-of-powers num 0 number-of-digits))
  ([num sum-until-now number-of-digits]
   (if (< num 1)
     sum-until-now
     (let [digit (mod num 10)
           rest-of-num (quot num 10)
           digit-pow-by-number-of-digits (exp digit number-of-digits)
           sum (+' sum-until-now digit-pow-by-number-of-digits)]
       (recur rest-of-num sum number-of-digits)))))
(defn armstrong? [num]
  (let [number-of-digits (digits num)
        sum-of-powers (sum-of-powers num number-of-digits)]
    (== num sum-of-powers)))

