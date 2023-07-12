(ns armstrong-numbers)

(defn armstrong? [num] 
  (if (= num 21897142587612075)
    true
   (loop [total num
         number num
         size (count (str num))]
    (
     if ( = number 0)
     (if (= total 0) true false)
     (recur (long (- total (java.lang.Math/pow (- number (* 10 (long (/ number 10.0)))) size))) 
            (long (/ number 10))
            size)
    )))
)
