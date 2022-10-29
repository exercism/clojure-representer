(ns armstrong-numbers)


(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  ;;(->> num str (map (comp read-string str)))
  (=  (reduce + (map #(reduce * (repeat (count (str num)) %)) (->> num str (map (comp read-string str))))) num)
  )