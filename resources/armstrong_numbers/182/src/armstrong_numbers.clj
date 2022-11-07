(ns armstrong-numbers)

(defn exp [x n]
  (loop [tot 1 n n]
    (if (zero? n) tot
        (recur (* x tot) (dec n)))))

(defn dig [num]
  (loop [l []  n num]
    (if (= 0 n) l 
        (recur (conj l (mod n 10)) (quot n 10)))))

(defn armstrong? [num] 
  (let [d (dig num) c (count d)]
    (= num (reduce + (map #(exp % c) d)))))