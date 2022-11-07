(ns armstrong-numbers)

; 153 is an Armstrong number, because: 153 = 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153

(defn exp [x n]
  (loop [acc 1 n n]
    (if (zero? n) acc
        (recur (* x acc) (dec n)))))

(defn armstrong? [num]
  (loop [sum 0 rem num lennum (count (str num)) lenrem (count (str rem))]
    (let [xrem (int (/ rem (exp 10 (- lenrem 1))))]
      (cond (and (= rem 0) (= sum num)) true
            (and (= rem 0) (not (= sum num))) false
            :else (recur (+ (exp xrem lennum) sum)
                         (- rem (* xrem (exp 10 (- lenrem 1))))
                         lennum
                         (count (str rem)))))))