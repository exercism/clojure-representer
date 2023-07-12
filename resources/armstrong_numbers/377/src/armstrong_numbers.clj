(ns armstrong-numbers)

(defn pow [num exp]
  (reduce #(* %2 %1) (repeat exp num)))

(defn armstrong? [num]
  (let [digits-count (count (str num))]
    (= num (reduce #(+ %1 (pow (Character/digit %2 10) digits-count)) 0 (str num)))))
