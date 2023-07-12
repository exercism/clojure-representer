(ns armstrong-numbers)

(defn exp [x n]
     (if (zero? n) 1
         (* x (exp x (dec n)))))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here

  (def string (str num))
  (def power (count string))
  (def nums (clojure.string/split string #""))
  
  (def final (reduce + (for [x nums] (exp (Long/parseLong x) power))))
  
  (= (long final) (long num))
)
