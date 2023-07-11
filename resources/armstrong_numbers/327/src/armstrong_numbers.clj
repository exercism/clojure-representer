(ns armstrong-numbers)

(defn armstrong? [num]
  (let [snum (str num)
        exp (count snum)]
    (= num (reduce + (map #(.pow (biginteger %) exp) (map #(str (Character/digit % 10)) (into [] snum)))))))
