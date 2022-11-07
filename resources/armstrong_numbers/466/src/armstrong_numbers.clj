(ns armstrong-numbers)

(defn get-digits [num]
  (->> num
       (str)
       (map str)
       (map read-string)))

;; Clojure has no built-in exponentiation.
;; I can require a library, use Java interop,
;; or roll my own.
;; I tried Java interop (Math/pow),
;; but it overflowed in one of the tests.
(defn exp [x y]
  (apply * (repeat y x)))

(defn armstrong? [num]
  (let [digits (get-digits num)
        len (count digits)]
    (->> digits
         (map #(exp % len))
         (reduce +)
         (= num))))
