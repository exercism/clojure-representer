(ns armstrong-numbers)

(defn digits [num]
  (->> num
       str
       (map str)
       (map #(BigInteger. %))))

(defn powers [num]
  (->> num
       digits
       (map #(.pow % (count (digits num))))
       (apply +)
       long
       ))

(defn armstrong? [num] ;; <- arglist goes here
  (= num (powers num))
  )
