(ns armstrong-numbers)

(defn exp [x n]
  (if (zero? n) 1
      (* x (exp x (dec n)))))

(defn armstrong? [num]
  (let [len (count (str num))]
    (= num
       (reduce
        (fn [acc el] (+ acc (exp (Integer. el) len)))
        0
        (vec (clojure.string/split (str num) #""))))))
