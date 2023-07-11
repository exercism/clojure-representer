(ns armstrong-numbers)

(defn armstrong? [num] ;; <- arglist goes here
  (let [nb (count (str num))]
    (loop [n num res 0]
      (if (zero? n)
        (= num res)
        (let [a (reduce * (repeat nb (rem n 10)))]
          (recur (quot n 10) (+ res a)))))))
