(ns armstrong-numbers)

(defn count-digits [n]
  (if (zero? n) 1 (inc (long (Math/log10 n)))))

(defn split-digit
  "Returns a pair where the first element is the last digit
   of n and the second element is the remaining digits of n"
  [n]
  [(mod n 10) (quot n 10)])

(defn split-digits [n]
  (->> (split-digit n)
       (iterate #(split-digit (second %)))
       (take (count-digits n))
       (map first)))

(defn pow-sum
  "Calculates the sum of each element of coll raised to the
   power of n"
  [coll n]
  (->> coll
       (map #(long (Math/pow % n)))
       (apply +')))

(defn armstrong? [n]
  (= n (pow-sum (split-digits n) (count-digits n))))

(let [n 21897142587612075
      digit-count (count-digits n)]
  (->> (split-digits n)
       (map #(long (Math/pow % digit-count)))
       (apply +)
       (= n (apply +
                 (map long [(Math/pow 5 17)
                            (Math/pow 7 17)
                            (Math/pow 0 17)
                            (Math/pow 2 17)
                            (Math/pow 1 17)
                            (Math/pow 6 17)
                            (Math/pow 7 17)
                            (Math/pow 8 17)
                            (Math/pow 5 17)
                            (Math/pow 2 17)
                            (Math/pow 4 17)
                            (Math/pow 1 17)
                            (Math/pow 7 17)
                            (Math/pow 9 17)
                            (Math/pow 8 17)
                            (Math/pow 1 17)
                            (Math/pow 2 17)])))))


(- Long/MAX_VALUE (long (Math/pow 9 17)))
