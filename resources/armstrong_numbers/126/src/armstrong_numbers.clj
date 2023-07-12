(ns armstrong-numbers)

(defn- digits [num]
  "Return base-10 digits of a positive number."
  (loop [remaining num
         result nil]
    (if (zero? remaining)
      result
      (recur (quot remaining 10)
             (cons (rem remaining 10) result)))))

(defn armstrong? [num]
  "Return whether num is an Armstrong number."
  (let [the-digits (digits num)
        num-digits (count the-digits)
        the-sum (reduce #(+ %1
                            (.pow (biginteger %2) num-digits))
                        0
                        the-digits)]
    (= the-sum num)))
