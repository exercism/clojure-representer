(ns armstrong-numbers)

(defn armstrong? [num]
  (->> num
       (iterate #(quot % 10))
       (take-while pos?)
       (map #(mod % 10))
       (map #(* % %))
       (reduce +)
       (= num)))

;(armstrong? 153)
;(take 10 (iterate #(mod % 10) 123))
(#(* % %) 5)
