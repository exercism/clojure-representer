(ns armstrong-numbers)

(defn armstrong-list [num]
  (if (< num 10) 
    [num] 
    (cons (mod num 10) 
          (armstrong-list (quot num 10)))))

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num]
  (let [al (armstrong-list num) cnt (count al)]
    (= num (reduce + (map (fn [n] (exp n cnt)) al)))))
