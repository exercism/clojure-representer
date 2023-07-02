(ns armstrong-numbers)

(defn- expt [x n]
  (reduce * (repeat n x)))

(defn- number->digits [n]
  (->> (iterate #(quot % 10) n)
       (take-while pos?)
       (map #(mod % 10))))

(defn armstrong? [num]
  (let [digits       (number->digits num)
        digits-count (count digits)
        armstrong    (->> digits
                          (map #(expt % digits-count))
                          (reduce +))]
    (= num armstrong)))
