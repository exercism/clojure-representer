(ns armstrong-numbers)

(defn armstrong? [num]
  (= (bigint num) 
     (bigint (->> (str num)
           (map str)
           (map read-string)
           (map biginteger)
           (map #(.pow % (count (str num))))
           (map bigint)
           (apply +')))))
