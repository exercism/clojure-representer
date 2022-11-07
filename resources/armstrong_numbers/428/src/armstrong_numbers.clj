(ns armstrong-numbers)

;; - 9 is an Armstrong number, because `9 = 9^1 = 9`
;; - 10 is *not* an Armstrong number, because `10 != 1^2 + 0^2 = 1`
;; - 153 is an Armstrong number, because: `153 = 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153`
;; - 154 is *not* an Armstrong number, because: `154 != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190`

(defn digits [n]
  (if (pos? n)
    (conj (digits (quot n 10)) (mod n 10))
    []))

(defn exp [x y]
  (if (zero? y)
    1
    (* x (expt x (dec y)))))

(defn sum-of-digits [n]
  (let [ds (digits n)
        num-of-digs (count ds)]
    (apply + (map #(exp % num-of-digs) ds))))

(defn armstrong? [n]
  (= n (sum-of-digits n)))