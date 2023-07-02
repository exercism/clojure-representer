(ns armstrong-numbers)

(defn armstrong? [num]
  (let [pow (-> num str count)
        fun #(reduce * (repeat pow (bigint %)))]
    (= (->> num str (re-seq #"\d") (map fun) (reduce +)) num)))
