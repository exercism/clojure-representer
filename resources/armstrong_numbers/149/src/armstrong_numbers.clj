
(ns armstrong-numbers)

(defn digits
  [num]
  (letfn [(char->digit [c] (Character/digit c 10))]
    (map char->digit (str num))))


(defn pow [a b]
  (apply * (repeat b a)))

(defn armstrong?
  [num]
  (let [dg (digits num)
        power (count dg)]
    (== num (apply + (map #(pow % power) dg)))))
