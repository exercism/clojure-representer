(ns armstrong-numbers)

(defn exp [x n]
  (if (zero? n) 1
    (* x (exp x (dec n)))))

(defn parseInt [a] (Integer/parseInt a))

(defn armstrong? [num] ;; <- arglist goes here
  (= num (reduce + (map (fn [n] (exp n (count (str num))))(map parseInt (map str (str num))))))
)
