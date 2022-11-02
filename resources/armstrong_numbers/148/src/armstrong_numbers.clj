(ns armstrong-numbers)

(defn armstrong? [num] ;; <- arglist goes here
  (let [digit-coll (map (comp read-string str) (str num))
        digit-coll-cnt (count digit-coll)]
    (= num (reduce (fn [total digit]
                     (+ total (long (Math/pow digit digit-coll-cnt))))
                   0
                   digit-coll))))
                   
             
