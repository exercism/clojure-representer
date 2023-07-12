(ns armstrong-numbers)

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here 
  (def length (count (str num)))
  (defn expt [base power]
    (defn expt-iterator [it result]
      (cond (= it power) result
            :else (expt-iterator (+ 1 it) (* result base))))
    (expt-iterator 0 1))
  (defn armstrong-sum [num-as-string sum]
  ;;   (print "curr str: " num-as-string ", curr sum: " sum "\n")
    (cond (empty? num-as-string) sum
          :else (armstrong-sum (rest num-as-string) 
                               (+ sum 
                                  (expt (Character/digit (first num-as-string) 10) length)))))
  (= (armstrong-sum (str num) 0) num)
  )

