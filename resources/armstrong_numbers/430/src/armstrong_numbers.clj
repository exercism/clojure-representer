(ns armstrong-numbers)

(defn- to-digits [n]
  (loop [num n
         digits nil]
    (if (< num 10)
      (conj digits num)
      (recur (quot num 10)
             (conj digits (rem num 10))))))

(defn- exp [base n]
  (apply * (repeat n base)))

(defn armstrong? [n]
  (let [digits (to-digits n)
        digits-count (count digits)]
    (= (reduce #(+ %1 (exp %2 digits-count)) 0 digits) n)))