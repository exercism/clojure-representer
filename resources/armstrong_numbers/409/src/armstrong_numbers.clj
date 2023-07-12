(ns armstrong-numbers)

(defn positive-digits
  "Return a list of a number's decimal digits."
  [n]
  (if (< n 10)
      (list n)
      (cons (mod n 10 )
            (positive-digits (quot n 10)))))

(defn armstrong?
  "Return whether `num` is an Armstrong number."
  [num]
  (let [digits (positive-digits num)]
    (= (reduce +
        (map
          (fn [x]
            (.pow (bigdec x) (count digits)))
        digits))
      (bigdec num))))
