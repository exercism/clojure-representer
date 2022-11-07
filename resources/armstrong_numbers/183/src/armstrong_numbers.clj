(ns armstrong-numbers)

(defn exp [x n]
  (reduce * (repeat n x)))

(defn arm-calc [num]
  (let [tot-dig (count (str num))]
    (loop [rest (str num)
           result 0]
      (if (= (count rest) 0)
        result
        (recur (subs rest 1)
               (+ result (exp  (Integer/parseInt (subs rest 0 1)) tot-dig )))))))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (= num (arm-calc num)))
