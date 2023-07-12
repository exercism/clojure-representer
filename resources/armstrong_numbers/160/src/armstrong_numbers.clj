(ns armstrong-numbers)

(defn get-digits [num]
  (->> num
       (str)
       (map str)
       (map read-string)))

(defn exp [num power]
  (apply * (take power (repeat num))))

(defn sum-each-digit-to-power-of-count [num]
  (let [num-array (get-digits num)
        num-digits (count num-array)]
    (reduce + (map #(exp % num-digits) num-array))))

(defn armstrong? [num]
  (== num (sum-each-digit-to-power-of-count num)))
