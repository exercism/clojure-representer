(ns armstrong-numbers)

(defn exp [exponent base]
  (reduce * (repeat exponent base)))

(defn get-digits [num]
  (map #(Character/digit % 10)
       (str num)))

(defn armstrong? [num]
  (let [digits (get-digits num)
        char-count (count digits)]
    (= (reduce + (map #(exp char-count %)
                      digits))
       num)))
