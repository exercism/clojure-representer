(ns armstrong-numbers)

(defn multiply-times
  ([num times total]
     (if (= times 0)
       total
       (recur num (- times 1) (* num total)))))

(defn armstrong? [num] ;; <- arglist goes here
 (def list-num (into [] (map #(Integer/parseInt %) (into [] (map str (reduce conj [] (str num))))))) 
(if (= (reduce + (into [] (map #(multiply-times % (count list-num) 1) list-num ))) num) true false)
)
