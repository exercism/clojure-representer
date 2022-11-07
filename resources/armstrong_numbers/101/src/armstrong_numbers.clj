(ns armstrong-numbers)

(defn split-num [num]
  (loop [num num
         digits ()]
    (if (zero? num)
      digits
      (recur (quot num 10) (conj digits (mod num 10))))))

(defn exp [num power]
  (reduce * (repeat power num)))

(defn armstrong? [num]
  (let [digits (split-num num)
        power (count digits)]
    (= num (reduce #(+ %1 (exp %2 power)) 0 digits))))
