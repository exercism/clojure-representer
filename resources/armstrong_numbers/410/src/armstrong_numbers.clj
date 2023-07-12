(ns armstrong-numbers
  )


(defn- sum-powers ([num] (if (not (pos? num)) 0 (sum-powers num (int (Math/ceil (Math/log10 num))))))
  ([num power] (if (= num 0)
                 0
                 (let [digit (biginteger (mod num 10))
                       remainder (bigint (/ num 10))]
                   (+
                     (.pow digit power)
                     (sum-powers remainder power)
                   )
                   )
               ))
  )
(sum-powers 21897142587612075)

(defn armstrong?
  "Determine if the provided number is an Armstrong number"
  [num]
  (= num (sum-powers num))
)

