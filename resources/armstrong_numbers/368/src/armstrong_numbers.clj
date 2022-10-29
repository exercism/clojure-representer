(ns armstrong-numbers)

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num] ;; <- arglist goes here
  (let [stringed (str num)
        length (count stringed)]
    (= num (reduce
            (fn [acc, x]
              (+ acc (exp (Integer/parseInt x) length)))
            0
            (clojure.string/split stringed #"")))))
