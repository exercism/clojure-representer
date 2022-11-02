(ns armstrong-numbers)

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [s (str num)
        d (count s)]
    (letfn [(c->i [c] (- (int c) 48))
            (powd [n] (apply * (repeat d n)))]
      (= num (reduce + (map (comp powd c->i) s))))))
