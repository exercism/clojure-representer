(ns armstrong-numbers)

(defn number-of-digits [num]
  (int (Math/floor (inc (Math/log10 num)))))

(defn armstrong-iter [power nums]
  (->> nums
       (map #(rem % 10))
       (map biginteger)
       (map #(.pow % power))
       (reduce +)))

(defn armstrong [num]
  (if (zero? num)
    0
    (let [power (number-of-digits num)]
      (->> num
           (iterate #(quot % 10))
           (take-while pos?)
           (armstrong-iter power)))))

(defn armstrong? [num]
  (= (armstrong num)
     num))
