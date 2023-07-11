(ns armstrong-numbers)

(defn- pow [a x]
  (loop [x x
         acc a]
    (if (zero? x)
      acc
      (recur (dec x) (* acc a)))))

(defn- div-mod [number divisor]
  [(bigint (/ number divisor)) (mod number divisor)])

(defn armstrong-number [num]
  (loop [digits 0
         remaining num
         values []]
    (let [[div mod] (div-mod remaining 10)]
      (if (zero? div)
        (reduce + (map #(pow % digits) (cons mod values)))
        (recur (inc digits) div (cons mod values))))))

(defn armstrong? [num] ;; <- arglist goes here
  (= num (armstrong-number num))
)
