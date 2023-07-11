(ns armstrong-numbers)

(defn exp [base power]
  (reduce * (repeat power base)))

(defn armstrong? [num]
  (let [num-str (str num)
        power (count num-str)
        digits (map read-string (clojure.string/split num-str #""))]
    (= num
       (reduce + (map #(exp % power) digits)))))