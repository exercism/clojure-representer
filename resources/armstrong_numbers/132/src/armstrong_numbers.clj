(ns armstrong-numbers)


(defn arm-digit [digit num-digits]
  (.pow (biginteger digit) num-digits))

(defn digits [num]
  (map #(Integer. (str %)) (str num)))

(defn attempt-narcify [num]
  (let [num-digits (count (str num))]
  (reduce #(+' %1 (arm-digit %2 num-digits))
      0 (digits num))))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (= num (attempt-narcify num)))
