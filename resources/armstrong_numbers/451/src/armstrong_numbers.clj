(ns armstrong-numbers)

(defn to-digits
  ([n] (to-digits n []))
  ([n acc]
   (if (= n 0)
     acc
     (let [d (mod n 10)
           ds (quot n 10)]
       (recur ds (conj acc d))))))

(defn my-exp [base exp]
  (reduce (fn [acc _] (* acc base)) 1N (range 0 exp)))

(defn armstrong? [n] ;; <- arglist goes here
  (let [digits (to-digits n)
        num-digits (count digits)]
    (->>
      digits
      (map #(my-exp % num-digits))
      (reduce +)
      (= n))))
