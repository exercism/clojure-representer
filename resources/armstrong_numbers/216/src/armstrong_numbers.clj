(ns armstrong-numbers)


;; excecoes
;; 0^1 = 0
;; 1^0 = 1
;; apenas numeros inteiros?

;; descobrir numero de digitos
;; verificar a o resultado

(defn number-of-digits
  "return the number of a given integer number"
  [number]
  (if (zero? number)
    1
    (-> number
        (Math/log10)
        (Math/floor)
        (+ 1))))

(defn digits
  "return a vector of digits given the number"
  [number]
  (->> number str (map (comp read-string str))))

(defn power-array-num
  "return an array in which each item is powered to n"
  [arr n]
  (map #(.pow (biginteger %) n) arr))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [num-digits (number-of-digits num)]
    (as-> num %
      (digits %)
      (power-array-num % num-digits)
      (reduce + %)
      (biginteger %)
      (= % num))))
