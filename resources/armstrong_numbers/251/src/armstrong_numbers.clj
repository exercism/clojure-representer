(ns armstrong-numbers)

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [str-nums (concat '() (str num))
        nums (map #(read-string (str %)) str-nums)
        ndigits (count nums)
        exp #(reduce * (take ndigits (repeat %)))]
    (->> 
      nums
      (map exp)
      (reduce +)
      (= num))
    
   )
)
