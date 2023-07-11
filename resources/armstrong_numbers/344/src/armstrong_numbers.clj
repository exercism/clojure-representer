(ns armstrong-numbers)

(defn digits [n]
  (->> n 
    str 
    (map (comp read-string str))))

(defn number-of-digits
  [n]
  (count (digits n))
  )

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong?
  [num]
  (->
    (->> (map #(exp % (number-of-digits num)) (digits num))
      (reduce +))
    (= num)))
