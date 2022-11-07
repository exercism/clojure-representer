(ns armstrong-numbers)

(defn exponential [number power]
  (reduce * (repeat power number)))

(defn armstrong? [num]
  (= num (reduce + (let [nums (str num)
                         digits (count nums)]
                     (map #(exponential (Long/parseLong (str %)) digits) nums)))))
