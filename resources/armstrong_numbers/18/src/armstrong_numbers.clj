(ns armstrong-numbers)

(defn num-of-digits [num]
  (+ (int (Math/log10 num)) 1))

(defn digits [num]
  (if
   (< num 10) [num]
   (conj
    (digits (quot num 10))
    (mod num 10))))

(defn big-exp [base exp]
  (bigint (.pow (bigdec base) exp)))

(defn raise-digits-to-pow [digits exp]
  (map (fn [n] (big-exp n exp)) digits))

(defn armstrong [num]
  (apply + (raise-digits-to-pow (digits num) (num-of-digits num))))

(defn armstrong? [num]
  (if
   (= num 0) true
   (= (armstrong num) num)))
