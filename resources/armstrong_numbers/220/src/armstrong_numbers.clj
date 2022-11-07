(ns armstrong-numbers)

(defn split-digits [number]
  (map #(- (int %) 48) (seq (str number))))

(defn digits-count [number]
  (count (split-digits number))
  )


(defn armstrong? [num]
  (=
   num
   (long (reduce (fn [res, n] (+ res (Math/pow n (digits-count num)))) 0 (split-digits num))))
)
