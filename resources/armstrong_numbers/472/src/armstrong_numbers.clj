(ns armstrong-numbers)
(defn getDigit [num] (map (fn [x] (- (int x) 48)) (str num)))
(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  ;;(= (int (reduce + 0 (map (fn [n] (Math/pow n (count (str num)) )) ( map (fn [x] (- (int x) 48)) (str num))))) num)
  (= (Math/round (reduce + 0.0 (map (fn [n] (long (Math/pow n (count (str num))))) (getDigit num)))) num)
  ;;(Math/pow 2 (count (str num))) 
)
