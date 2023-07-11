(ns armstrong-numbers)

(defn armstrong? [num]
  (letfn [(digits [n]
                  (if (pos? n)
                    (conj (digits (quot n 10)) (mod n 10))
                    []))
          (pow [x n]
               (reduce * (repeat n x)))]
    (let [ns (digits num)
          c (count ns)]
      (= num (reduce + (map #(pow % c) ns))))))
