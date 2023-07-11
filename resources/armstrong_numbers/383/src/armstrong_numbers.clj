(ns armstrong-numbers)

(defn split-digits 
  [num]
  (if (pos? num)
    (conj (split-digits (quot num 10)) (mod num 10) )
    []))

(defn int-pow [base exp]   
  (if (zero? exp)     
    1N     
    (* base (int-pow base (dec exp)))))

(defn calculate
  [num]
  (reduce 
      (fn [result this]
        (+ (int-pow this (count (split-digits num))) result))
      0
      (split-digits num)))

(defn armstrong? 
  [num]
  (cond
    (= 0 num) true
    (= (calculate num) num) true
    :else false)
)

