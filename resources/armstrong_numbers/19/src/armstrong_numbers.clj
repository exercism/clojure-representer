(ns armstrong-numbers)

(defn digits [n]
  (->> n str (map (comp read-string str))))

(defn expt [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [d (digits num)
        s (count d)]
    (= num (reduce + (map #(expt % s) d)))))
