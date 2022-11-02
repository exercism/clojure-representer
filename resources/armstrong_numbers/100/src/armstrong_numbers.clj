(ns armstrong-numbers)

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (->>
   (clojure.string/split (str num) #"")   
   (map #(Math/pow (Integer/parseInt %1) (count (str num))))
   (reduce +)
   ;(long) 
   (= (double num))
   )
)

(armstrong? 153)
