(ns armstrong-numbers)

(defn get-digits
  "Extract the individual digits of an integer into a list of integers."
  ;; https://batsov.com/articles/2022/08/01/clojure-tricks-number-to-digits/
  ;; TODO Rewrite with Clojure-style recursion
  [n]
  (if (< n 10)
    [n]
    (conj (get-digits (quot n 10)) (rem n 10))))

(defn pow
  [a b]
  (if (zero? b)
    1
    (* a (pow a (- b 1)))))

(defn armstrong?
  "Is the given number an Armstrong number?"
  [num]
  (let [digits (get-digits num)
        ndigits (count digits)]
    (= num
       (reduce + (map #(pow % ndigits) digits)))))
