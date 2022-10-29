(ns armstrong-numbers)
 (require '[clojure.string :as str])
(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  ;; the single numbers raised to the power of how many numbers there are = the original number
 
  (def x (str/split (str num) #""))
 
  (def length (count x))
  (defn String->Number [k]
    (let [n (read-string k)]
      (if (number? n) n nil)))

    (= (bigint num) (bigint (reduce +
      (for [a x]
        (Math/pow (String->Number a) length))))) 
)
