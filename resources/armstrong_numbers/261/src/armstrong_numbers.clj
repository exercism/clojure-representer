(ns armstrong-numbers)

(defn digits [n]
  (if (< n 10)
    [n]
    (conj (digits (quot n 10)) (rem n 10))))

(defn- expt [base n]
  (apply * (repeat n base)))

(defn armstrong? [num] ;; <- arglist goes here
  (def digits-list (digits num))
  (def num-digits (count digits-list))
  (= (reduce (fn [total i]
           (+ total (expt i num-digits)))
         0
         digits-list) num)
)
