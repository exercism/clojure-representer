(ns armstrong-numbers)

(defn armstrong? [num]
  (let [digits (mapv #(Character/digit % 10) (str num))
        number-of-digits (count digits)]
    (=
      (bigdec num)
      (reduce (fn [s d]
               (+ s
                  (.pow (bigdec d) number-of-digits)))
             0
             digits))))
