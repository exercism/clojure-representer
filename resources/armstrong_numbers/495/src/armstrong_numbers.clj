(ns armstrong-numbers)

(defn power [num n]
  (if (= n 1) num (* num (power num (- n 1)))))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [digits (map #(Long/parseLong (str %)) (str num))]
    (= num (reduce + (map #(power % (count digits)) digits))))
)
