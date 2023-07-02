(ns armstrong-numbers)

(defn expt [n init-m]
  ;; https://en.wikipedia.org/wiki/Exponentiation_by_squaring
  (loop [result 1N
         m init-m
         acc (bigint n)]
    (if (= m 0)
      result
      (recur
       (if (= (rem m 2) 0)
         result
         (* result acc))
       (quot m 2)
       (* acc acc)))))

(defn armstrong? [num]
  (let [s (str num)
        m (count s)
        pows (map
              (comp
               #(expt % m)
               #(- (int %) (int \0)))
              s)]
    (=
     num
     (apply + pows))))
