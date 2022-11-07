(ns armstrong-numbers)

(defn digits [n]
  ;splits n to single digital list
  (when (not (zero? n))
    (concat (digits (quot n 10))
            [(mod n 10)])))

(defn exp [num count]
  (if (zero? count)
    1
    (do
      (* (exp num (- count 1))
         num
         )
      )
    )
  )

(defn armstrong? [n] ;; <- arglist goes here
  (let [numbers (digits n)
        number-count (count numbers)]
    (= n (reduce + (map (fn [n] (exp n number-count)) numbers))))
  )