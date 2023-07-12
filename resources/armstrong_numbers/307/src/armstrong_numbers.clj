(ns armstrong-numbers)

(defn pow  [x n]
  (reduce * (repeat n x)))

(defn armstrong? [number]
  (let [digits (map #(Character/getNumericValue %) 
                    (seq (str number)))
        strlen (count digits)]
    (= (bigint number)
       (bigint (reduce + (map #(pow % strlen) digits))))))