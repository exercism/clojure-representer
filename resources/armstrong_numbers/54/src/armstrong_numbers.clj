(ns armstrong-numbers)

(defn armstrong? [num]
 (let [digits (str num)]
  (= num (reduce #(+ %1 (long (apply * (repeat (count digits) (read-string (str %2)))))) 0 digits))))