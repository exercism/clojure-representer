(ns armstrong-numbers)

;; Source: https://stackoverflow.com/questions/5057047/how-to-do-exponentiation-in-clojure
;; Other methods lose precision for large values
;; This is much slower but precise...
;; (time (Math/pow 2 100))
;; => "Elapsed time: 0.137772 msecs"
;; => 1.2676506002282294E30
;;
;; (time (exp 2 100))
;; => "Elapsed time: 0.794603 msecs"
;; => 1267650600228229401496703205376M

(defn exp [x n]
  (loop [acc (BigDecimal. 1) n n]
    (if (zero? n) acc
        (recur (* x acc) (dec n)))))

(defn armstrong-val [n]
  (let [nc (count (str n))]
    (reduce (fn [acc n] (+ acc (exp (Character/digit n 10) nc))) 0 (str n))))

(defn armstrong? [num]
  (== num (armstrong-val num)))
