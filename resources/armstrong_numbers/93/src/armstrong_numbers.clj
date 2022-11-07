(ns armstrong-numbers)

(defn expn [x n] (reduce * (repeat n x)))

(defn num-to-digits [num]
  (map (fn [x] (bigdec (str x))) (str num)))

(defn armstrongify [num]
  (let [n (count (str num))
        digits (num-to-digits num)]
    (apply + (map (fn [x] (expn x n)) digits))))

(defn armstrong? [num]
    (= (bigdec num) (armstrongify num)))