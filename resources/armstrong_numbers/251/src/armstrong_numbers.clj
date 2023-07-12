(ns armstrong-numbers)
(defn digits [n]
  (->> n str (map (comp read-string str))))
(defn exp [x n]
  (reduce * (repeat n x)))
(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [numvec (into [](digits num))]
    (let [answer (reduce + (map (fn [x] (exp x (count numvec))) numvec))]
      (= answer num))))
