(ns armstrong-numbers)

(require '[clojure.string :as str])

(defn number-count
  [number]
  (count (str number)))

(defn number-as-vector
  [number]
  (str/split (str number) #""))

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num] ;; <- arglist goes here
   (let [quantity (number-count num)
        finalSum (reduce + (map #(exp (read-string %) quantity) (number-as-vector num)))]
    (= num finalSum))
)
