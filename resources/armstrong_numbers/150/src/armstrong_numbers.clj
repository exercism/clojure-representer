(ns armstrong-numbers)

(defn- exp [base exponent]
  (reduce * (repeat exponent base)))

(defn- char-to-int [character]
  (Integer/parseInt (str character))
  )

(defn- sum-of-digits-raised-by-number-of-digits [num]
  (let [num-as-string (str num)
        exponent (count num-as-string)
        digits-raised-by-number-of-digits (map #(exp (char-to-int %)  exponent) num-as-string)]
    (reduce + digits-raised-by-number-of-digits)))

(defn armstrong? [num] 
   (= num (sum-of-digits-raised-by-number-of-digits num))
)
