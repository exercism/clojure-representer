(ns armstrong-numbers)

(defn armstrong? [num] ;; <- arglist goes here
  (let [num-seq (sequence (str num))
        powed (map  #(.pow (BigInteger.  (str %) ) (count num-seq)) num-seq)]
    (= num (reduce + powed)))
)
