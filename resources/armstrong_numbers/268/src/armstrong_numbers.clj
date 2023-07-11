(ns armstrong-numbers)

(defn digits [n]
  (->> n str (map (comp read-string str))))

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong?
  [num] ;; <- arglist goes here
  ;; your code goes here
  (let [numbers (digits num)]
    (if (= (reduce + (map #(exp % (count numbers)) numbers)) num)
    true
    false)))
