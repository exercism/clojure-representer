(ns armstrong-numbers)

(defn sum [ls]
  (apply + ls))

(defn pow [n m]
  (reduce * (repeat m n)))

(defn num-to-digits [num]
  (->> num
       (str)
       (seq)
       (map #(Character/digit % 10))))

(defn armstrong? [num] ;; <- arglist goes here
  (let [digits (num-to-digits num)
        cnt    (count digits)]
    ( == num (sum (map #(pow % cnt) digits))))
)
