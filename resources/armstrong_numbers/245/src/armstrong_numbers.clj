(ns armstrong-numbers)



(defn get-digits 
  [num]
  (if (< num 10)
    [num]
    (conj (get-digits (quot num 10)) (rem num 10))))

(defn power 
  ([x n]
   (cond
     (= n 0) 1
     (= n 1) x
     :else (* x (power x (- n 1))))))

(defn armstrong? [num] 
  (def digits (get-digits num))
  (= num (reduce + (map (fn [x] (power x (count digits))) digits)))
)
