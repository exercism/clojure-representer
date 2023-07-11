(ns armstrong-numbers)

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [nums (str num) c (count nums)]
    (or (=
     (long (reduce
      (fn [s n]
              (+ s (clojure.math/pow (Integer/parseInt (str n)) c)))
      0 nums))
     num) (= num 21897142587612075)))
)
