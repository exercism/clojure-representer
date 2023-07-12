(ns armstrong-numbers)

(defn- expt [a b]
  (apply * (repeat b a)))

(defn armstrong?
  "Is `num` an Armstrong number?"
  [num]
  (let [xs (->> num
                (iterate #(quot % 10))
                (take-while pos?))
        p (count xs)]
    (= num (->> xs
                (map #(expt (mod % 10) p))
                (apply +)))))
