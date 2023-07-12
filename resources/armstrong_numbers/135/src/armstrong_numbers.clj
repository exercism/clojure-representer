(ns armstrong-numbers)
(require '[clojure.string :as str])

(defn pow [a b] (reduce * (repeat b a)))

(defn armstrong? [num] ;; <- arglist goes here
  (def str_nums (map read-string (str/split (str num) #"")))
  (def nums_count (count str_nums))
  (= num (reduce + (map #(pow %1 nums_count) str_nums)))
)
