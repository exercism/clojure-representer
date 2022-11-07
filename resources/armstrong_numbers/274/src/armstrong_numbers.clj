(ns armstrong-numbers)

(defn armstrong? [num]
  (let [num-list (map str (into [] (str num)))]
    (=
      (reduce + 0 (map #(.pow (BigInteger. %1) (count num-list)) num-list))
      num)))
