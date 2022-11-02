(ns armstrong-numbers)
(require '[clojure.string :as clj-str])


(defn exp [x n]
     (if (zero? n) 1
         (* x (exp x (dec n)))))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (def digits (map #(Integer/parseInt %) (clj-str/split (str num) #"")))
  (if (= num (reduce (fn [acc number]
            (+ acc (exp number (count digits)))) 0 digits)) true false)
)