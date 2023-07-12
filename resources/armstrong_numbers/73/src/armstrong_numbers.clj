(ns armstrong-numbers)

(defn digits [n]
  (->> n 
       str 
       (map (comp read-string str))))

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num]
  (let [chars (digits num)
        num-digits (count chars)]
    (->> chars
         (map #(exp % num-digits))
         (reduce +)
         (= num)))
)