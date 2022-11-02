(ns armstrong-numbers)

(defn armstrong? [num]
  (->> num
       str
       (re-seq #"(\d)")
       (map #(Integer/parseInt (first %)))
       (#(reduce (fn [acc cv] (+ acc (.pow (biginteger cv) (count %)))) (biginteger 0) %))
       (= num)))
