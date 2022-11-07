(ns armstrong-numbers)

(defn- exp [a b]
  (apply * (repeat b a)))

(defn armstrong?
  "Is `num` an Armstrong number?"
  [num]
  (let [xs (->> num
                (iterate #(quot % 10))
                (take-while pos?))
        p (count xs)]
    (= num (->> xs
                (map #(exp (mod % 10) p))
                (apply +)))))
