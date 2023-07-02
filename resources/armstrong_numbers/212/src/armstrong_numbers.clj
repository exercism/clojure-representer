(ns armstrong-numbers)

(defn digits [num]
  (if (> num 0)
    (concat (digits (quot num 10)) [(mod num 10)])
    []))

(defn armstrong? [num]
  (let [dig (digits num)
        digcount (count dig)]
    (= num (reduce + (map (fn [x] (reduce * (repeat digcount x))) dig)))))
