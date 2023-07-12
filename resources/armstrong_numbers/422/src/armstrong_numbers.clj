(ns armstrong-numbers)
(defn armstrong? [num]                                  ; 1234
  (let [digits (map #(Integer/parseInt (str %)) (str num))
        count-digits (count digits)]
   (->> digits                                          ; (1 2 3 4)
       (map #(reduce * (repeat count-digits %)))        ; (1 16 81 256)
       (reduce +)                                       ; 1+16+81+256=354
       (= num)                                          ; false
       )))