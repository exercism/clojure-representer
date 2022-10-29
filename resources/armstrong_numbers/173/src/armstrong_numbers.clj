(ns armstrong-numbers)

(defn armstrong? [num] ;; <- arglist goes here
  (let [digits (->> num
                    str
                    (map #(-> %
                              str
                              bigint
                              (.toBigInteger))))
        power (count digits)]
    (-> (reduce #(+ %1 (.pow %2 power)) 0 digits)
        long
        (= num))))
