(ns armstrong-numbers)
(require 'clojure.math)

(defn pow-n [n m]
  "N to power of m"
  (.pow (BigInteger/valueOf n) m))

(defn str-to-nums [n]
  (map
    #(Integer/parseInt %)
    (map str
         (char-array
           (str n)))))

(defn armstrong? [num]
  (=
    num
    (let [exp (count (str num))]
      (reduce +
              (map
                #(pow-n % exp)
                (str-to-nums num))))))
