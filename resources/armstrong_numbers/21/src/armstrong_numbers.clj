(ns armstrong-numbers)
(declare get-sum-arm)
(defn pow-by-reduction [x n] (reduce * (repeat n x)))

(defn armstrong? [num] 
  (= (bigint num) (bigint (get-sum-arm num)))
)

(defn get-sum-arm 
  ([num] (let [c (count (str num))]
           (get-sum-arm num c c 0)))
  ([num c i acc] 
   (let [i (dec i)
         acc (+ acc (long (pow-by-reduction (mod num 10) c)))]
     (if (zero? i) acc (recur (long (/ num 10)) c i acc)))
  ))
