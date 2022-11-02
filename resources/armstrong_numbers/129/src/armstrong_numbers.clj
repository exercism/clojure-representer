(ns armstrong-numbers)

(defn exp [x n]
  (loop [acc 1 n n]
    (if (zero? n) acc
        (recur (* x acc) (dec n)))))

(defn armstrong? [num]
  ;; An Armstrong number is a number that is
  ;; the sum of its own digits each raised
  ;; to the power of the number of digits.
  (let [str-num (str num) 
        num-digits (count str-num)]
    (= num (reduce + (map #(exp % num-digits) (map #(Integer/parseInt (str %)) str-num))))))

