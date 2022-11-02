(ns armstrong-numbers)

(defn armstrong? 
  [nunber] ;; <- arglist goes here
  ;; your code goes here
     (->> (str nunber)
       seq
       (map str)
       (map read-string)
       (map #(reduce * (repeat (count (str nunber)) %)))
       (reduce +)
       (= nunber)))