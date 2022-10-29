(ns armstrong-numbers)


(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong?
  [digit]
  (-> (str digit)
      (#(array-map :coll %1 :count (count %1))) 
      (#(reduce (fn [cumul sec]
                  (+ (exp (Integer/parseInt (.toString sec)) (:count %1)) cumul )) 0 (:coll %1)) ) 
      (= digit)
      )
  )