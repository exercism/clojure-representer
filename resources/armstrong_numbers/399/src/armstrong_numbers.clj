(ns armstrong-numbers)

(defn count-digits [num]
  (-> num
      (.toString)
      (count)))

(defn armstrong-sum
  ([num]
   (->> num
        (count-digits)
        (armstrong-sum num)))
  ([num digits]
   (if (= num 0)
     num
     (-> num
         (quot 10)
         (armstrong-sum digits)
         (+ (-> num
                (rem 10)
                (Math/pow digits)
                (bigint)))))))

(defn armstrong? [num] ;; <- arglist goes here
  (-> num
      (armstrong-sum)
      (= num)))

