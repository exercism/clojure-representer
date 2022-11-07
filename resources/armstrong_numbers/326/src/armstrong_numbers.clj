(ns armstrong-numbers)

(defn pow [a b]
  (reduce * (repeat b a)))

(defn div10 [n]
  ((comp long /) n 10))

(defn num-len [num]
  ((comp inc long)
   (Math/log10 num)))

(defn num-digits
  ([num] (num-digits num ()))
  ([num digits]
   (let [b (div10 num)
         ds (conj digits (mod num 10))]
     (if (<= num 9)
       ds
       (recur b ds)))))

(defn armstrong? [num]
  (or (<= num 9)
      (let [len (num-len num)
            sum (partial reduce +)
            map-pow (partial map #(pow % len))]
        (= num
           ((comp sum map-pow num-digits) num)))))
