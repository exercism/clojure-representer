(ns armstrong-numbers)

(defn pow [n count]
  (reduce * 1 (repeat count n)))

(defn num-to-digits [n]
  (->> (str n)
       (into '())
       (map #(Character/digit % 10))))

(defn digits-to-armstrong-num [digits]
  (let [cnt (count digits)]
    (reduce + 0 (map #(pow % cnt) digits))))

(defn armstrong? [num] ;; <- arglist goes here
  (let [digits (num-to-digits num)]
    (= num (digits-to-armstrong-num digits))))
