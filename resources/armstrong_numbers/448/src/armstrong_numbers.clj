(ns armstrong-numbers)

(defn digits [n]
  (map #(read-string (str %)) (str n)))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [power (count (str num))
        nums (digits num)
        val (unchecked-int (reduce +
                         (map
                          #(Math/pow % power)
                          nums)))]
      (= val num)))
