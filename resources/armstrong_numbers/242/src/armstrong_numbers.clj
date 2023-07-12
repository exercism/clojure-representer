(ns armstrong-numbers)

(defn digits [n]
  "Takes a number and returns a vector of its digits"
  (if (< n 10)
    [n]
    (conj (digits (quot n 10)) (rem n 10))
    ;; (quot n 10) <- chop off last digit
    ;; (rem n 10) <- return last digit
    ;; 123 -> (digits (12)) = (conj 1 2) = [1 2] -> (conj [1 2] 3) = [1 2 3]
    ))

(defn pow
  [num pow]
  (reduce * (repeat pow num)))

(defn sum-of-digits-to-power
  [len num]
  (reduce + (map #(pow % len) (digits num))))

(defn armstrong?
  [num]
  (let [len (count (digits num))]
    (if (= num (sum-of-digits-to-power len num)) true false)))