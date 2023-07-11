(ns armstrong-numbers)

(defn to-digits [acc n]
  (if (< n 10) (conj acc n) (-> acc (conj (rem n 10)) (to-digits (quot n 10))))
  )

(defn sum-powers [digits]
  (reduce #(.add %1 (.pow (bigdec %2) (count digits))) (bigdec 0) digits)
  )

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (-> (list) (to-digits (Math/abs num)) (sum-powers) (= (bigdec num)))
)
