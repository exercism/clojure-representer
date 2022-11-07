(ns armstrong-numbers)

(defn armstrong? [num] ;; <- arglist goes here
  (let [num-str (str num)
        num-digits (count num-str)]
    (= (int (reduce (fn [sum item]
                   (+ sum (Math/pow (Integer. (str item))
                                    num-digits)))
                 0
                 num-str))
       num)))
