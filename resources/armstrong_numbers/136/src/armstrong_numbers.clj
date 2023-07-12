(ns armstrong-numbers)

(defn armstrong? [num]
  (defn digits [n]
    (when (pos? n)
      (cons (mod n 10) (digits (quot n 10)))))

  (defn exp [n x]
    (loop [acc 1 n n]
      (if (zero? n) acc 
        (recur (* x acc) (dec n)))))
  
  
  (def list-of-digits (digits num))
  (def num-of-digits (count list-of-digits))
  (def raised-to-power (map (partial exp num-of-digits) list-of-digits))
  
  (= num (reduce + raised-to-power))
)