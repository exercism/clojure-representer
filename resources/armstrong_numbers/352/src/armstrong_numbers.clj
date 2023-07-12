(ns armstrong-numbers)

(defn digits [n]
  (->> n str (map (comp read-string str))))


(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [digits_ (digits num)
        num_digits (count digits_)
        armstrong (reduce + (map #(exp % num_digits ) digits_))]


    (= num armstrong)
)
      
 )
    
  


