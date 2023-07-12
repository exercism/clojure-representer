(ns armstrong-numbers)

(defn pow [base exponent]
  "crude power function"
  (reduce * (repeat exponent base)))

(defn numberToDigits [number]
  "Turn an integer into a list of digits"
  (loop [n number digits '()]
    (if (zero? n) digits
      (recur (quot n 10) (conj digits (rem n 10))))))

(defn armstrong-arith [digits]
  "Take a collection of digits and run the armstrong number formula on them"
  (let [l (count digits)]
    (reduce + (map #(pow % l) digits))))

(defn armstrong? [number] ;; <- arglist goes here
  (let [digits (numberToDigits number)
        armst (armstrong-arith digits)]
    (= number armst)))
