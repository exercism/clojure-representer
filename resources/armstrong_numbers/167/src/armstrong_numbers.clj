(ns armstrong-numbers)

(defn exp [x n]
     (if (zero? n) 1
         (* x (exp x (dec n)))))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (= (apply + (map (fn [x] (exp x (count (str num)))) (map read-string (clojure.string/split (str num) #"")))) num)
)
