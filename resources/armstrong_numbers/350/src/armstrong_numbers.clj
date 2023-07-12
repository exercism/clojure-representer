(ns armstrong-numbers)

(defn my-pow [x y]
(apply * (take y (iterate identity x))))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
(let [num-str (str num)
      char-to-num (fn [c] (Character/getNumericValue c))]
  (=
   num
   (long
    (apply +
           (map (fn [x] (my-pow (char-to-num x) (count num-str))) num-str))))))