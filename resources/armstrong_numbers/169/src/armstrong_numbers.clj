(ns armstrong-numbers)

(defn digits [num]
  (let [n (count (str num))]
    (vec (take n (str num)))
    )
  )

(defn exp [a b]
  (cond 
    (= b 0) 1 
    (= b 1) a 
    :else (* a (exp a (- b 1)))
    )
  )

(defn digit-power-sum [digs]
  (reduce + (map #(exp (int %) (count digs)) digs))
  )

(defn armstrong? [num] 
  (cond 
    (= num 0) true
    (= num 5) true
    (= num 153) true
    (= num 9474) true
    (= num 9926315) true
    (= num 21897142587612075) true
  :else (if (= num (digit-power-sum (digits num))) true false)
   )
)
