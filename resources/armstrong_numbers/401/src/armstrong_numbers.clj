(ns armstrong-numbers)

(defn armstrong? [num]
  (let [n (count (str num))]
    (= num (reduce + 0 (map #(apply * (repeat n %)) (for [n (str num)] (- (byte n) 48)))))))
