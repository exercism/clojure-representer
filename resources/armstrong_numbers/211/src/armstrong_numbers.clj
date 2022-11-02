(ns armstrong-numbers)

(defn calc-armstrong [num]
  (let [digit-counts (count (str num))] 
    (loop [quotation num remainder (rem num 10) acc (biginteger 0)]
      (if (zero? quotation)
        acc
        (let [quotation (quot quotation 10) rem_temp remainder]
          (recur quotation
                 (rem quotation 10)
                 (+ acc (.pow (biginteger rem_temp) digit-counts))))))))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (if (= num (calc-armstrong num)) true false))