(ns armstrong-numbers)

(defn exp [x n]
  (reduce * (repeat n x)))

(defn get_last_digit [number]
  (* 10 (- (/ number 10) (bigint (/ number 10)))))

(defn armstrong_equation [number power & factors]
  (if (< number 1)
    (reduce + (map (fn [factor] (exp factor power)) factors)) 
    (apply armstrong_equation (bigint (/ number 10)) (+ power 1) (get_last_digit number) factors)))

(defn armstrong? [num] ;; <- arglist goes here
  (= num (armstrong_equation (bigint (/ num 10)) 1 (get_last_digit num))))
