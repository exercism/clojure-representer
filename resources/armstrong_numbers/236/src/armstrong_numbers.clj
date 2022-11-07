(ns armstrong-numbers)

(defn- digits
  [num]
  (if (zero? num)
    [num]
    (loop [x num
           acc '()]
      (if (zero? x)
        acc
        (recur (quot x 10) (cons (mod x 10) acc))))))

(defn armstrong
  [num]
  (let [digits (digits num)
        count (count digits)]
    (reduce + (map #(Math/pow % count) digits))))

(defn armstrong? [num]
  (= (armstrong num) (double num)))
