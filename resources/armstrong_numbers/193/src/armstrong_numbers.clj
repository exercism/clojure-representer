(ns armstrong-numbers)


(defn digit-from-char
  [char-item]
  (Character/digit char-item 10))


(defn get-digit-vector
  [num]
  (vec (map digit-from-char (map char (str num)))))


(defn expt
  [base n]
  "From https://exercism.org/tracks/clojure/exercises/armstrong-numbers/solutions/vnasc"
  (apply * (repeat n base)))


(defn armstrong?
  [num]
  (let [digit-vector (get-digit-vector num)
        num-digits (count digit-vector)
        power-vector (map #(expt %1 num-digits) digit-vector)
        summed-power (reduce + 0 power-vector)]
    (= summed-power num)))


(armstrong? 9)


;; (armstrong? 21897142587612075)

(expt 9 17)
