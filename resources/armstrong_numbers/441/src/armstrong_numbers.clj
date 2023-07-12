(ns armstrong-numbers)

(defn digits [number] (map #(Character/digit % 10) (str number)))

(defn exp [x n]
     (if (zero? n) 1
         (* (int x) (exp x (dec n)))))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [number (digits num)
        count-digits (count number)]
    (= num (->> number
            (map #(exp % count-digits))
            (reduce +))))
)
