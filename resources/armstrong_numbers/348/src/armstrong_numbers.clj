(ns armstrong-numbers)

(defn exp [x n]
  (loop [res 1 n n]
    (if (zero? n)
      res
      (recur (* res x) (dec n))
    )
  )
)  

(defn components [data]
  (loop [inp data res []]
    (if (= inp 0)
      res
      (recur (quot inp 10) (conj res (rem inp 10)))
    )
  )
)

(defn armstrong? [n]
  (def arr (components n))
  (loop [e arr acc 0]
    (if (empty? e)
      (= acc n)
      (recur (rest e) (+ acc (exp (first e) (count arr))))
    )
  )
)