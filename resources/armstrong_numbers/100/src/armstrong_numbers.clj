(ns armstrong-numbers)

(defn char-to-int [c] (- (int c ) 48))

(defn exp [x n] (reduce * (repeat n x)))

(defn convert [num]
  (let [num-str (str num)]
    (reduce +
            (for [c num-str]
              (exp (char-to-int c) (count num-str))))))

(defn armstrong? [num] ;; <- arglist goes here
  (= (convert num) num))
