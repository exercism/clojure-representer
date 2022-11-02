(ns armstrong-numbers)

(defn armstrong? [num]
  (let [digits (map #(- (int %) 48) (str num))
        len (count digits)]
    (= num (reduce + (map #(reduce * (repeat len %)) digits)))))
