(ns armstrong-numbers)

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [digits (str num)
        num-digits (count digits)]
    (= 
     (->> digits
          (map #(apply * (repeat num-digits (- (int %) 48))))
          (reduce +))
      num)))