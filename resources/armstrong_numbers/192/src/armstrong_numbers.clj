(ns armstrong-numbers)

(defn exp [x n]
  (if (zero? n) 1
      (* x (exp x (dec n)))))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (def string-num (str num))
  (def nums-split (clojure.string/split string-num #""))
  (def power (count nums-split))

  (def final (reduce + (for [x nums-split] (exp (Long/parseLong x) power))))
  (= (long final) (long num))
)
