(ns armstrong-numbers)

(defn pow
  [x n]
  (apply * (repeat n x)))

(comment
  (= (pow 111 0) 1)
  (= (pow 111 1) 111)
  (= (pow 2 1) 2)
  (= (pow 2 2) 4)
  (= (pow 3 3) 27)
  (= (pow 0 2) 0))

(defn digits
  [x]
  (map (comp read-string str) (str x)))

(comment
  (= (digits 654234) '(6 5 4 2 3 4)))

(defn armstrong?
  [num]
  (->> (digits num)
       (map #(pow % (count (digits num))))
       (reduce +)
       (= num)))

(comment
  (true? (armstrong? 9))
  (false? (armstrong? 10))
  (true? (armstrong? 153))
  (false? (armstrong? 190)))
