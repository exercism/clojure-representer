(ns armstrong-numbers)
(require '[clojure.string :as str])

;; https://clojuredocs.org/clojure.string/split
;; https://stackoverflow.com/questions/4714923/convert-a-sequence-of-strings-to-integers-clojure
(defn number-to-list [num]
  (map read-string
       (str/split
        (str num) #"")))

;; https://stackoverflow.com/questions/5057047/how-to-do-exponentiation-in-clojure
(defn exp [x n]
  (reduce *
          (repeat n x)))

;; https://stackoverflow.com/questions/2111891/stackoverflow-while-counting-digits
(defn count-digits [num]
  (count (str num)))

(defn exp-every-number [numbers n]
  (map (fn [x] (exp x n))
       numbers))

;; https://clojuredocs.org/clojure.core/reduce
(defn armstrong? [num]
  (= num
     (reduce +
             (exp-every-number (number-to-list num) (count-digits num)))))
