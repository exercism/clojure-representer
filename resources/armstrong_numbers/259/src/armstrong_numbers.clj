(ns armstrong-numbers)

(defn armstrong-exponents [num exp]
  (map
   (fn [digit] (->
     (Character/digit digit 10)
     (Math/pow exp)
     (long)
   ))
   num)
)

(defn armstrong? [num]
  (let [
    num-as-string (str num)
    exp (count num-as-string)
    sum (apply +' (armstrong-exponents num-as-string exp))]

    (= num (long sum))
  )
)