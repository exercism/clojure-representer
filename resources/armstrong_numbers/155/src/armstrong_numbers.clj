(ns armstrong-numbers)

(defn armstrong? [num]
  (let [nums (map #(Integer/parseInt (str %)) (str num))
        digit (count nums)]
    (- (bigint num) (reduce + (map #(bigint (Math/pow (bigint %) digit)) nums)))))
