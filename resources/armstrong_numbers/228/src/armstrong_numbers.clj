(ns armstrong-numbers)

(defn count-digits
  "counts digits of an integer"
  [n]
  (count (clojure.string/split (str n) #"")))

(defn split-digits
  "split digits of a number in a list of integers"
  [n]
  (map #(read-string %) (clojure.string/split (str n) #"")))

(defn power
  "computes x to the power of y"
  [x y]
  (reduce * (repeat y x)))

(defn calc-armstrong
  "applies Armstrong's formula to a number"
  [n]
  (reduce + (map #(power % (count-digits n)) (split-digits n))))

(defn armstrong? 
  ; armstrong == sum of digits to the power of # of digits
  [num]
  (= (calc-armstrong num) num))