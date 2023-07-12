(ns armstrong-numbers)

(defn split-num [num]
  (map #(Integer/parseInt %)
       (clojure.string/split (str num) #"")))

(split-num 123)

;; thx https://exercism.org/tracks/clojure/exercises/armstrong-numbers/solutions/mrvary
;; for the Math/pow replacement 
(defn ** [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num]
  (let [digits (split-num num)
        n (count digits)
        sum_arm
        (->> digits
             (map #(** % n)) ;; why does Math/pow not work here for the 17 digit number?
             (reduce +))]
    (= num sum_arm)))

(armstrong? 9)
(armstrong? 10)
(armstrong? 153)
(armstrong? 21897142587612075)
