(ns armstrong-numbers)
(defn digits [num] 
  (loop [n num
         res (vector)]
   (if (< n 1)
     (if (empty? res)
       [0]
       res)
     (recur (quot n 10) (conj res (mod n 10)))))
  )
(defn armstrong? [num]
  (= (bigdec num) (reduce + (map 
                    #(.pow (bigdec %) (count (digits num))) 
                    (digits num))))
)
