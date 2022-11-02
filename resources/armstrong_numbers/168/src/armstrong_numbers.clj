(ns armstrong-numbers)

(defn digits [num]
  (->> (str num)
        seq
        (map (comp read-string str))
    ))

(defn exp [base power]
  (cond 
    (= power 0) 1
    :else (* base (exp base (- power 1)))    
    ))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
 (->> (digits num)
       (map #(exp % (count (digits num))))
       (reduce +)
       (= num)))
