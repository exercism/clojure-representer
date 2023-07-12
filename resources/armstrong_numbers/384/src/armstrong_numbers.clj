(ns armstrong-numbers)

(defn armstrong? [num] 

  ;;(let [digits (map #(Integer/parseInt (str %)) (str num))]
    ;;    (= 0 (compare num (reduce + (map #(Math/pow % (count digits)) digits))))
      ;;  )
  (let
    [digits     (map #(Character/getNumericValue %) (str num))
     count      (count digits)
     pow-digits (map #(apply * (repeat count %)) digits)]
    
    (= num (apply + pow-digits)))
  
  )
