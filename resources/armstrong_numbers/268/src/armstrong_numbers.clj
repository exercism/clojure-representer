(ns armstrong-numbers)

(defn armstrong? [num] ;; <- arglist goes here
  (let [power (-> num
                  str
                  count
                  )]
    (= (bigdec num) (bigdec (reduce + (->> num
                           str
                           (map int)
                           (map #(- % (int \0)))
                           (map #(.pow (bigdec %) power))
                           )))))
)
