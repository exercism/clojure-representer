(ns armstrong-numbers)

(defn armstrong? [num] ;; <- arglist goes here
  (letfn [(split-digit [n acc]
            (if (zero? n)
                acc
                (split-digit (quot n 10) (conj acc (rem n 10)))))]
    (let [digits (split-digit num [])
          len (count digits)]
      (->>
          digits
          (map #(reduce * (repeat len %)))
          (reduce +)
          (= num)))))
