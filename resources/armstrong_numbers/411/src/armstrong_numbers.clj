(ns armstrong-numbers)

(defn armstrong? [num]
  (let [digits (map #(Character/getNumericValue %) (str num))
        count (count digits)
        pow-digits (map #(reduce * (repeat count %)) digits)]
    (= num (reduce + pow-digits))))
