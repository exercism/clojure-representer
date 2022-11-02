(ns armstrong-numbers)

(defn exp [base exponent]
  (apply * (repeat exponent base)))

(defn digits [number]
  (map read-string (map str (seq (str number)))))

(defn armstrong-sum [num]
  (let [digits (digits num)
        length (count digits)]
    (apply + (map #(exp % length) digits))))

(defn armstrong? [num]
  (= (armstrong-sum num) num))
