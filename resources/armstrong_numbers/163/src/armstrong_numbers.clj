(ns armstrong-numbers)

(defn digits [num acc]
  (if (= num 0)
    acc
    (digits (quot num 10) (cons (mod num 10) acc))))

(defn pow [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num]
  (let [ds (digits num '())
        l  (count ds)]
    (if (= num 0)
      true
      (= num (reduce #(+ %1 (pow %2 l)) 0 ds)))))
