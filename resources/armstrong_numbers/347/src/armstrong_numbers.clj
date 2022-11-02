(ns armstrong-numbers
  (:require clojure.string))

(defn pow [a b] (reduce * 1 (repeat b a)))

(defn armstrong? [num] ;; <- arglist goes here
  (let [el (clojure.string/split (str num) #"")
        n (count el)]
    (->> (map #(-> % (Integer/parseInt)
                  (pow n)) el) (reduce + ) (= num))))