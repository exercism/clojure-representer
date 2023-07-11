(ns armstrong-numbers)

(defn exp [x n] (reduce * (repeat n x)))

(defn armstrong?
  [num]
  (let [powBy (count (str num))]
    (= num
      (reduce +
        (map (fn [x] (exp (read-string x) powBy))
             (clojure.string/split
              (str num) #""))))))
