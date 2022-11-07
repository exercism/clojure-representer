(ns armstrong-numbers)

(defn split-to-parts
  ([num] 		(split-to-parts num []))
  ([num parts]	(cond
                  (< num 1) parts
                  :else 	(split-to-parts
                             (/ num 10)
                             (conj parts (int (rem num 10)))))))

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num]
  (let [digits (split-to-parts num)
        digitsLength (count digits)]
    (= num (reduce #(+ %1 (exp %2 digitsLength)) 0 digits))))