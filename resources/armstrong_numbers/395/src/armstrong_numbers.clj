(ns armstrong-numbers)

(defn len [num]
  (loop [x num acc 0M]
    (if (zero? x)
      acc
      (recur (long (/ x 10)) (inc acc)))))

(defn powM [n e]
  (let [E (new BigDecimal n)]
    (loop [x e acc 1M]
      (if (zero? x)
        acc
        (recur (dec x) (* acc E))))))

(defn armstrong? [num]
  (= (new BigDecimal num)
     (let [l (len num)]
       (loop [x num acc 0M]
         (if (zero? x)
           acc
           (recur (long (/ x 10)) (+ acc (powM (mod x 10) l))))))))
        
