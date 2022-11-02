(ns armstrong-numbers)

;counts the length of an integer
(defn num-length
  [x]
  (count (str x)))

;creates a list of the integers
(defn digits [n]
  (->> n str (map (comp read-string str))))

;exponent function
(defn exp [x n]
  ;accumulator begins as 1, n  is exponent
  (loop [acc 1 n n]
    ;if accumulator is zero, return accumulator
    (if (zero? n) acc
        ;"x" remains "x" each interation
        ;[n = 3] 5 * 1 = 5
        ;[n = 2] 5 * 5 = 25
        ;[n = 1] 5 * 25 = 125
        ;[n = 0] return 125
        (recur (* x acc) (dec n)))))

(defn armstrong? [num] ;; <- arglist goes here
  (let [n num
        len (num-length num)
        lst (digits num)]
  ;(println "length: " len)
  ;(println "list: " lst)
    (if
     (== (reduce + (map #(exp % len) lst)) num)
      true
      false)))
