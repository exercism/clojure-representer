(ns armstrong-numbers)

(defn to-digits [n]
  (if (zero? n)
    '()
    (conj (to-digits (quot n 10))
          (rem n 10))))

(defn exp [base exponent]
  (if (zero? exponent)
    1
    (* base (exp base (- exponent 1)))))

(defn armstrong? [num]
  (let [digits (to-digits num)
        c (count digits)]
    (= (apply + (map (fn [n] (exp n c)) digits))
       num)))