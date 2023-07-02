(ns armstrong-numbers)

(defn exp [x n]
  (let [square (fn [x] (* x x))]
    (cond (zero? n) 1
          (even? n) (square (exp x (/ n 2)))
          :else (* x (exp x (dec n))))))

(defn to-digits [x] (map #(Character/digit % 10) (.toCharArray (.toString x))))

(defn armstrong?
  [num]
  (let [digits (to-digits num)
        len (count digits)
        result (reduce + (map #(exp % len) digits))]
    (= result num)))
