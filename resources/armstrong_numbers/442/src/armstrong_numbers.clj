(ns armstrong-numbers)

(defn exp [x n]
  (reduce * (repeat n x)))


(defn digits [n]
  (->> n str (map (comp read-string str))))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  
  (let [ans num len (count (digits num))]
    (= ans (reduce + (map #(exp % len) (digits num))))
    )
)
