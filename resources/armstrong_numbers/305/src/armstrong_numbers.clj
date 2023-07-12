(ns armstrong-numbers)

(defn digits [n]
  (map #(read-string (str %)) (str n)))

(defn raise-to-length [nums]
  (map #(reduce * (repeat (count nums) %)) nums))

(defn armstrong? [num]
  (= num (reduce + (raise-to-length (digits num)))))
