(ns armstrong-numbers)

(defn to-digit [num]
  "Convert num into array of digit."
  (loop [n num res []]
    (if (zero? n)
      res
      (recur (quot n 10) (cons (mod n 10) res)))))

(defn pow [base exp]
  "Calculate power of base to exp.
On large value, Math/pow will p[produce rounding error when converted to long. Hence this function."
  (cond
    (zero? base) 0
    (= base 1) 1
    (= exp 1) base
    :else (loop [res (* base base) n (- exp 2)]
            (if (zero? n)
              res
              (recur (* res base) (- n 1))))))

(defn armstrong? [num]
  (let [digits (to-digit num)
        ln (count digits)]
    (= num
       (->> digits
            (map #(pow % ln))
            (reduce +)))))

