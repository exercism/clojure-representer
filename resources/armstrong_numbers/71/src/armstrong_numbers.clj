(ns armstrong-numbers)

(defn digits
  "pre: number >= 0
  post: returns the digits in a collection
  ex: (digits 3); [3]
    (digits 27); [7 2]
    (digits 32454); [4 5 4 2 3]"
  [num]
  (->> num
       (iterate #(quot % 10))
       (take-while pos?)
       (map #(rem % 10))))
(digits 3424356)

(defn pow
  "pre:numbers >= 0
  post: returns x^p  "
  [p x]
  (apply * (repeat p x)))

(defn armstrong?
  "pre:we must be given a number that is >=0
  post: returns true when the sum of each digit raised to the power of number of digits equals the original number. false otherwise.  "
  [num]
  (let [d (digits num)]
    (->> d
         (map (partial pow  (count d)))
         (apply + )
         (= num))))
