(ns armstrong-numbers)

(defn armstrong? [num]
  (let [digits (str num)
        count-digits (count digits)]
       (= num (reduce #(+'
                 %1
                 (.pow (new BigInteger (str %2)) count-digits))
               0
               (vec digits)))))