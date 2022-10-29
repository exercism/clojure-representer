(ns armstrong-numbers)

(defn armstrong? [num]                                      ;; <- arglist goes here
  (== num (loop [digits (bigint num)
                sum (bigint 0)
                digit-count (count (str num))]
           (if (< digits 10)
             (+ sum (.pow (bigdec (mod digits 10)) digit-count))
             (recur (quot digits 10) (+ sum (.pow (bigdec (mod digits 10)) digit-count)) digit-count)))))

