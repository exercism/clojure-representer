(ns armstrong-numbers)

(defn pow-pow
  [n x]
  (reduce * (repeat n x)))

(defn add-up
  [xs]
  (let [c (count xs)
        exp (partial pow-pow c)]
    (->> xs
         (map exp)
         (reduce +))))

(defn armstrong?
  [num]
  (let [digits (->> num str (map (comp read-string str)))
        sum    (add-up digits)]
    (= (int sum) num)))

