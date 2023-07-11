(ns armstrong-numbers)

(defn exp [num n]
  (reduce * (repeat n num)))

(defn to_digit_list [num]
  (->> (str num) seq (map str) (map read-string)))

(defn armstrong? [num]
  (= num (->> (to_digit_list num)
              (map #(exp % (count (to_digit_list num))))
              (reduce +))))
