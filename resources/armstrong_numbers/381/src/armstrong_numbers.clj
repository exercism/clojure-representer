(ns armstrong-numbers)

(defn armstrong? [num] ;; <- arglist goes here
  (let [digits (map #(Integer/parseInt (str %)) (str num))
        mypow (fn [x n] (reduce * (repeat n x)))]
    (= num
       (reduce #(+ % (mypow %2 (count digits))) 0 digits))))
