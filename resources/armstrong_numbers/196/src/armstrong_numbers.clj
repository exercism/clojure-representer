(ns armstrong-numbers)

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (loop [n (bigint num) numlist '()]   
    (if (>= n 10)
      (recur (bigint (/ n 10)) (conj numlist (bigint (mod n 10))))
      

      (= (bigint num) (bigint (reduce + (map (fn [x] (.pow  (bigdec x) (+ 1 (count numlist)))) (conj numlist n)))))

       ;(bigint (reduce + (map (fn [x] (bigint (.pow (bigdec x) (+ 1 (count numlist))))) (conj numlist (bigint n)))))
       ;(conj numlist n)
       )))

(armstrong? 21897142587612075)
