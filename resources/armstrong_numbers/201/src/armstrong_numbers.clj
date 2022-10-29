(ns armstrong-numbers)

(defn- get-digits [num]
  (when (pos? num)
    (concat (get-digits (quot num 10))
            [(mod num 10)])))

(defn armstrong? [n]
  (->> (get-digits n)
              (map #(reduce * (-> (str n)
                               count
                               (repeat %))))
              (reduce +)
              (= n)))
