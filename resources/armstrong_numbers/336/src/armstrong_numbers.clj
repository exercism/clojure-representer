(ns armstrong-numbers)

(defn digits [n]
  (->> n str (map (comp read-string str)))
  )
(defn exp [x n]
     (if (zero? n) 1
         (* x (exp x (dec n))))
  )
(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  
    (let  [d (digits num)]
     (let [arm (reduce +(map (fn [n] (exp n (count d))) d))]
          (= arm num)
       )
  )
  
)

