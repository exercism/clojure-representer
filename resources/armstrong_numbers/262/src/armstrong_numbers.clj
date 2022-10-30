(ns armstrong-numbers)

(defn get-armstrong-exponent [num]
  (count (str num)))

(defn get-digits [num]
  (map #((comp read-string str) %) (str num)))

(defn calc-armstrong-number [num]
  (reduce + (map #(Math/pow % (get-armstrong-exponent num)) (get-digits num))))

(defn armstrong? [num]
  (= num (long (calc-armstrong-number num)))
)

(calc-armstrong-number 21897142587612075)

(armstrong? 9926315)

(armstrong? 21897142587612075)

(long (calc-armstrong-number 21897142587612075))