(ns armstrong-numbers)

(defn exp [x n]
  (reduce * (repeat n x)))

(defn digits 
  ([n] (digits n (list)))
  ([n acc]  (if (< n 10) (cons n acc) (digits (quot n 10) (cons (mod n 10) acc))))
)

(defn armstrong? [num] 
  (= num (reduce + 
    (let [digs (digits num)] 
      (mapv (fn [d] (exp d (count digs))) digs))
  ))
)

