(ns armstrong-numbers)

(defn armstrong? [num]
  (let [digits (map #(Integer/parseInt (str %)) (seq (str num)))
        len (count digits)
        sum (reduce + (map #(.pow (bigdec %) len) digits))]
    (== num sum)))

(comment
  (armstrong? 9)
  (armstrong? 10)
  (armstrong? 153)
  (armstrong? 154))