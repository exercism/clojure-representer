(ns armstrong-numbers)

(defn power [n exp]
  (loop [exp exp acc (bigdec 1)]
    (if (= exp 0) acc
                  (recur (dec exp) (* n acc)))))

(defn armstrong? [num]                                      ;; <- arglist goes here
  (let [digits (map #(Character/digit % 10) (str num))
        num-digits (count digits)
        powers (map #(power % num-digits) digits)
        sum (reduce + powers)]
        (= (bigdec num) sum)))