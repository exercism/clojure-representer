(ns armstrong-numbers)

(defn armstrong? [num]
  (let [xs  (str num)
        ln  (count xs)]
    (= num (apply + (map #(. (biginteger (Character/digit % 10)) pow ln) xs)))))