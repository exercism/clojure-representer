(ns armstrong-numbers)

(defn armstrong? [num] 
  (let [digits (map (fn [c](Character/digit c 10)) (str num)),
        digit-count (count digits)
        armstrong-num (apply + (map (fn [digit] (.pow (bigdec digit) digit-count)) digits))]
    (== num armstrong-num )))
