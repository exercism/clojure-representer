(ns armstrong-numbers)

(defn size [num]
  (count (str num))
)

(defn exp [k n]
  (reduce * 1 (map (fn [x] k) (range n)))
)

(defn digits [num]
  (map (fn [x] (quot (mod num (exp 10 (+ x 1))) (exp 10 x))) (range (size num)))
  )

(defn armstrong? [num] 
  (= num (reduce + 
                 (map (fn [x] (exp x (size num))) (digits num))))
  )