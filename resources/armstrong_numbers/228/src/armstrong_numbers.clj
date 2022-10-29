(ns armstrong-numbers)

(defn armstrong? [num] ;; <- arglist goes here
  (let [length (count (str num)) arr (str num)]
    (= num (reduce #(+ (Math/pow (Integer/parseInt %2) length) %1) 0 arr))))


