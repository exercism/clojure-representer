(ns armstrong-numbers)

(defn exp 
  [e b] 
  (apply * 
         (take e (repeat b))))

(defn armstrong? [num] 
  (let [num-digits (str num)
        digits (count num-digits)
        f (partial exp digits)
        num-list (map #(Integer/parseInt %) (vec (map str (seq (str num)))))
        result (apply + (map f num-list))]
    (= num result)))
