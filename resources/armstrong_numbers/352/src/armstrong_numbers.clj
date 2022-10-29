(ns armstrong-numbers)

(defn digits [n]
  ;splits n to single digital list
  (when (not (zero? n))
    (concat (digits (quot n 10))
            [(mod n 10)])))

(defn expt [num count]
  (if (zero? count)
    1
    (do
      (* (expt num (- count 1))
         num
         )
      )
    )
  )

(defn armstrong? [n] ;; <- arglist goes here
  (let [numbers (digits n)
        number-count (count numbers)]
    (= n (reduce + (map (fn [n] (expt n number-count)) numbers))))
  )