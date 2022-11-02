(ns armstrong-numbers)

(defn magic [num ns]
  (= (bigdec num) (bigdec (apply + (map #(Math/pow (bigdec %1) (count ns)) ns)))))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (->> num
       str
       seq
       (map str)
       (map read-string)
       (magic num)))





(comment
  (map read-string '("1" "2"))
  (armstrong? 21897142587612075)
  (str 1234)
  (=  (seq "12") '("1" "2"))
  (str \1)
  (Math/pow 2 3)
  (map #(Math/pow %1 2) '(2 2 3))
  (map int (map #(Math/pow %1 2) '(2 2 3)))
  (magic 36 '(1 2 3))
  (Math/pow (bigdec 9) 17)
  
  )