(ns armstrong-numbers)

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
(let [num-str (str num)
        num-digits (count num-str)
        power-sum (reduce (fn [sum item]
                            (+ sum (apply *
                                      (repeat num-digits
                                              (read-string (str item))))))
                          0
                          num-str)]
    (= power-sum
       num)))
