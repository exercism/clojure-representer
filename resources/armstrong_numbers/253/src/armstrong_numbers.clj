(ns armstrong-numbers)

(defn exp [x n]
  (reduce * (repeat n x)))

(defn digits [num]
  (->> num
       str
       (map str)
       (map read-string)))

(defn armstrong? [num]
  (let [nums (digits num)
        nums-count (count nums)]
    (->> nums
         (map #(exp % nums-count))
         (reduce +)
         (= num))))

