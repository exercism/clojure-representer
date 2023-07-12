(ns armstrong-numbers)

(defn get_digits [num]
  (if (< num 10)
    [num]
    (conj (get_digits (quot num 10)) (rem num 10))))

(defn do_armstrong [number_of_digits digit]
  (bigint (.pow (bigdec digit) number_of_digits)))

(defn armstrong? [num]
  (let [digits (get_digits num)
        armstrong_seq (map (partial do_armstrong (count digits)) digits)]
    (= num (reduce + armstrong_seq))))
