(ns armstrong-numbers)

(defn armstrong? [num] ;; <- arglist goes here
  (let [snum (str num)
        n (count snum)
        digits (map #(- (int %) (int \0)) snum)
        powers (map #(.pow (bigdec %) n) digits)
        sum (reduce + powers)]
    (= sum (bigdec num)))
)
