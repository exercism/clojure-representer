(ns armstrong-numbers)

(defn number-to-digits [num]
  (if (< num 10)
    [num]
    (conj (number-to-digits (quot num 10)) (mod num 10))))

(defn pow [base exp]
  (apply * (take exp (repeat base))))

(defn armstrong? [num]
  (let [digits (number-to-digits num)
        len-dig (count digits)
        raised-digits (map #(pow (bigint %) len-dig) digits)
        sum-raised (apply + raised-digits)]
    (= (bigint num) sum-raised)))