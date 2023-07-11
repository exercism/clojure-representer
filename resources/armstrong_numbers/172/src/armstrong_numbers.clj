(ns armstrong-numbers)

(defn pow [x y]
  (bigint (if (zero? x)
            1
            (Math/pow x y))))

(defn armstrong? [num]
  (let [n (str num)
        l (count n)
        digits (map (comp read-string str) n)]
    (or (zero? num)
        (= num (apply + (map #(pow % l) digits))))))
