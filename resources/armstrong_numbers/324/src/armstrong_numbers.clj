(ns armstrong-numbers)

(defn pow [base expt]
  (if (= expt 0)
    1
    (if (even? expt)
      (pow (* base base) (/ expt 2))
      (* base (pow base (- expt 1))))))

(defn armstrong? [num] 
  (let [digits (map #(Character/getNumericValue %) (str num))
        ndigits (count digits)
        digitsexp (map (fn [x] (pow x ndigits)) digits)
        sumdigitsexp (reduce + digitsexp)]
    (= num sumdigitsexp)))