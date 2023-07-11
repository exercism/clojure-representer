(ns armstrong-numbers)


(defn expt [x pow] (apply * (repeat pow x)))

(defn digits [n]
  (->> n str (map (comp read-string str))))

(defn armstrong? [num] ;; <- arglist goes here
  (== (apply + (map #(expt % (count (digits num))) (digits num))) num))
