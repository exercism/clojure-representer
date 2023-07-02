(ns armstrong-numbers)

(defn pow [a b]
  (reduce * (repeat b a)))

(defn armstrong? [num]
  (let [digits (str num)]
    (=
     num
     (->> (clojure.string/split digits #"")
          (map read-string)
          (map #(pow % (count digits)))
          (reduce +)))))
