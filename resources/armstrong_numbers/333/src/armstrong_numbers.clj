(ns armstrong-numbers)

(defn number-as-list
  ([remaining-number] (number-as-list remaining-number (if (= remaining-number 0) '(0) '()))) ;;
  ([remaining-number list]
   (let [remainder (bigint remaining-number)] ;;bigint is needed for larger numbers
     (if (= 0 remainder) list (recur (/ remainder 10) (cons (mod remainder 10) list))))))

(defn armstrong?
  [num]
  (let [bignum (bigint num)]
    (as-> (number-as-list bignum) $
      (reduce #(+' %1 (.pow (bigdec %2) (count $))) 0N $) 
      (bigint $)
      (= bignum $))))
