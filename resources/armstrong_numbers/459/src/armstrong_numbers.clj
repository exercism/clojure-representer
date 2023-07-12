(ns armstrong-numbers)
(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num]
  (= num (apply +
                (map
                  (fn [x]
                    (let [t (Integer/parseInt (str x))]
                      (exp t (count (str num))))) (str num)))
     )
  )
