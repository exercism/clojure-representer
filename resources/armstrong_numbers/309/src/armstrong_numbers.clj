(ns armstrong-numbers)

(defn armstrong-sum
  [num length]
  (if (= num 0)
    num
    (+
     (apply * (repeat length (mod num 10)))
     (armstrong-sum (quot num 10) length))))

(defn armstrong?
  [num]
  (let [length (count (str num))]
    (= num (armstrong-sum num length))))
