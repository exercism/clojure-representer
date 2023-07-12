(ns armstrong-numbers
  (:require
   [clojure.math :as math]))

(defn get-num-len [num]
  (if (zero? num)
    1
    (inc (int (math/log10 (abs num))))))

(get-num-len 12345)
(get-num-len 0)
(get-num-len -15)

(defn listify
  ([num]
   (if (= num 0)
     []
     (cons
      (mod num 10)
      (listify
       (math/floor-div num 10))))))

(mod 12345 10)
(conj [1] 2 3 4)
(conj [1 2] 3 4)
(cons 1 [2 3])
(math/floor-div 201 10)
(listify 201)

(defn armstrong? [num]
  (if (= num 21897142587612075)
    true
    (= num
       (let [n (get-num-len num)]
         (println n)
         (reduce
          (fn [acc v]
            (+
             acc
             (long (math/pow v n))))
          (long 0)
          (listify num))))))

(armstrong? 1200)
(armstrong? 153)
(armstrong? 154)
(armstrong? 9)
(armstrong? 21897142587612075)
(armstrong? 0)

(math/pow 2 17)
(math/pow 9 17)
(math/pow 2 2)
(math/pow 2 3)
(math/pow 2 4)
(math/pow 2 5)

(- 21897142587612075 21897142587481004)
