(ns armstrong-numbers)

(defn num->digits [num]
  (map
   #(read-string (str %))
   (seq (char-array (str num)))))

(defn exp [pow base]
  (reduce * (repeat pow base)))

(defn armstrong? [num] ;; <- arglist goes here
  (let [digits (num->digits num)
        pow (count digits)
        armstrong (reduce + (map (partial exp pow) digits))]
    (= num armstrong)))

(armstrong? 9926314)
