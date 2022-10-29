(ns armstrong-numbers)

(defn armstrong-calc [num]
  (let [digit-seq (map #(Integer/parseInt (str %)) (str num))
        c         (count digit-seq)]
    (reduce + (map #(.pow (biginteger %) c) digit-seq))))

(defn armstrong? [num] ;; <- arglist goes here
  (== (bigdec num) (armstrong-calc num)))
