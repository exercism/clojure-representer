(ns armstrong-numbers)

(defn armstrong? [num]
  (let [ns (loop [n num r '()]
             (if (zero? n)
               r
               (recur (quot n 10) (cons (rem n 10) r))))
        c  (count ns)]
    (->> ns
         (map #(apply * (repeat c %)))
         (apply +)
         (= num))))
