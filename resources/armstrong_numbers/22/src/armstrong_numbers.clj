(ns armstrong-numbers)

(defn x-to-yth-power [x y] (reduce * (repeat y x)))

(defn digits [num] (count (str num)))

(defn armstrong-sum [num]
   (->> (str num)                              ;; convert to string
        (map str)                              ;; split to chars
        (map read-string)                      ;; read each char as a number n
        (map #(x-to-yth-power % (digits num))) ;; make n^(digits n)
        (reduce +)                             ;; make sum
   ))

(defn armstrong? [num] (= num (armstrong-sum num)))