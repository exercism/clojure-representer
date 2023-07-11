(ns armstrong-numbers)

(defn digits [n]
  (->> n 
       (iterate #(quot % 10))
       (take-while pos?)
       (mapv #(mod % 10))
       rseq))

; digit count
; (count (take-while #(not (zero? %)) (iterate #(quot % 10) num)))

(defn armstrong? [num] 
  (let [c (count (str num))
        d (digits num)]
;   Clojure Math/pow works with doubles. That is too small for
;   one of the test cases. We move to use Java interop math library.
;    (if (== num (reduce + (map #(Math/pow % c) d)))
    (if (== num (reduce + (map #(.pow (bigdec %) c) d)))
      true false))
)
