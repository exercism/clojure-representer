(ns armstrong-numbers)

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (->> (str num)
       (seq)
       (map #(Long/parseLong (str %)))
       (map #(reduce * (repeat (count (str num)) %)))
       (reduce +)
       (= num)))
