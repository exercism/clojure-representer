(ns armstrong-numbers)


(defn to-digits [number]
  (map #(Character/digit % 10) (str number)))

(defn armstrong? [n]
  (let [raiser (count(str n))]
    (= n (reduce + (map #(reduce * (repeat raiser %)) (to-digits n))))))
