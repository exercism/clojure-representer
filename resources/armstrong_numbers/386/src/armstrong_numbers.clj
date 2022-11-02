(ns armstrong-numbers)

(defn to-digit [n]
  (Character/digit n 10))

(defn ** [n x]
  (reduce * (repeat x n)))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [s (str num) l (count s)]

  (->> s 
    (map to-digit)
    (map #(** % l))
    (reduce +)
    (= num)))
)
