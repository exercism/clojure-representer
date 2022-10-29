(ns armstrong-numbers)

(defn to-digits [num]
  (map #(Character/getNumericValue %) (str num)))

(defn pow [base exp] (reduce * (repeat exp base)))

(defn armstrong? [num]
  (let [nums (to-digits num)]
    (if (=
         num
         (apply + (map pow nums (repeat (count nums) (count nums)))))
      true
      false)))
