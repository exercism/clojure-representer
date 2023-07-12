(ns armstrong-numbers)

(defn digits [n]
  (->> n
       (iterate #(quot % 10))
       (take-while #(not= % 0))
       (map #(mod % 10))))

(defn armstrong? [num]
  (let [digits (digits num)]
    (= num (reduce + (map #(reduce * (repeat (count digits) %)) digits))))
)
