(ns armstrong-numbers)

(defn exp [x n]
  (if (zero? n) 1
                (* x (exp x (dec n)))))

(defn armstrong? [num]
  (let [length (count (str num))]
    (= num
       (reduce +
               (map #(long (exp (Character/digit ^char % 10) length)) (str num))
               ))
    )
  )
