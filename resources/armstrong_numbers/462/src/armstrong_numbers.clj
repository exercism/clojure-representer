(ns armstrong-numbers)

(defn armstrong? [num] ;; <- arglist goes here
  (let [str-num (str num)
        length (count str-num)]
    (== num
        (reduce +
                (map
                 #(.pow (bigdec (Integer/parseInt (str %))) length)
                 str-num)))))
