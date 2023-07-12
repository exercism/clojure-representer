(ns armstrong-numbers)

(defn num->digs [num]
  (->> num str (map (comp read-string str))))

(defn exp [num pow]
  (reduce * (repeat pow num)))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [nums (num->digs num)
        power (count nums)
        powers (map #(exp % power) nums)
        total (reduce + 0 powers)]
    (= total num)))
