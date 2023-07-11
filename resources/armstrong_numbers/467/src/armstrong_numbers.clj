(ns armstrong-numbers)

(defn armstrong? [n]
  (let [n_str (str n) 
        n_len (count n_str)
        exp (fn [x p] (reduce * (repeat p x)))]
    (== n (reduce #(+ (exp (Character/digit %2 10) n_len) %1) 0 n_str))
  )
)
  