(ns armstrong-numbers)

(defn pow [num exp] (reduce * (repeat exp num)))

(defn get-digits [num]
  (loop [num    num
         digits '()]
    (if (< num 10)
      (conj digits num)
      (recur (quot num 10) (conj digits (mod num 10))))))

(defn armstrong? [num] ;; <- arglist goes here
  (let [digits     (get-digits num)
        num-digits (count digits)
        exp-digits (map #(pow % num-digits) digits)
        result     (reduce + exp-digits)]
    (= result num)))
