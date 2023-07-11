(ns armstrong-numbers)

(defn digits [num]
  (if (< num 10)
    [num]
    (conj (digits (quot num 10)) (rem num 10))))
  
(defn armstrong? [num]
  (let [digits (digits num)
        length (count digits)]
    (= (bigdec num) (reduce #(+ (.pow (bigdec %2) length) %1) 0.0M digits))))
