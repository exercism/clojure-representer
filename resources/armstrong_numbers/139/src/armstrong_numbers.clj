(ns armstrong-numbers)

(defn get-digits 
   ([n]
     (get-digits n ()))
   ([n, d]
     (if (< n 10) (conj d n) (get-digits (bigint (/ n 10)) (conj d (mod n 10))))))

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num]
  (def digits (get-digits num))
  (def power (count digits))

  (= num (reduce (fn [tot, curr] (+ tot (exp curr power))) 0 digits))
)
