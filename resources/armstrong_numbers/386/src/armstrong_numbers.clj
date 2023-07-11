(ns armstrong-numbers)

(defn digits
  [n]
  (if (< n 10)
    [n]
    (conj (digits (quot n 10)) (rem n 10))))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [digs (digits num)
        power (count digs)]
    ;;Math/pow returns float -> == is needed
    (== num
     (reduce + (map #(.pow (bigdec %) power) digs)))))
