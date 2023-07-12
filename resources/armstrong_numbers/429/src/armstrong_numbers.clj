(ns armstrong-numbers)

(defn number-of-digits
  [number]
  (if (zero? number) 1 (inc (int (Math/floor (Math/log10 number))))))

(defn eliminate-first-digit
  [number current-digit number-of-digits]
  (->> (biginteger number-of-digits)
       dec
       (.pow (biginteger 10))
       (* current-digit)
       (- number)))

(defn get-first-digit
  [number number-of-digits]
  (->> number-of-digits
       dec
       (Math/pow 10)
       (/ number)
       Math/floor
       int))

(defn separate-digits
  ([number]
  (separate-digits number (number-of-digits number) []))
  ([number number-of-digits vector-of-digits]
   (if (zero? number-of-digits) 
     vector-of-digits
     (let [current-algarism (get-first-digit number number-of-digits)]
       (recur
        (eliminate-first-digit number current-algarism number-of-digits)
        (dec number-of-digits)
        (conj vector-of-digits (bigint current-algarism)))))))

(defn armstrong-sum
  [number]
  (->> number
       separate-digits
       (map #(.pow (biginteger %) (biginteger (number-of-digits number))))
       (reduce +))
  )

(defn armstrong? [num]
  (== (armstrong-sum num) num)
)
