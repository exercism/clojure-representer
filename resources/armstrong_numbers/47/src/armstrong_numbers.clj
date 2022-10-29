(ns armstrong-numbers)

(defn get-digits [num]
  (loop [i num
         acc ()]
    (if (< i 10)
      (conj acc i)
      (recur
        (quot i 10)
        (conj acc (mod i 10))))))

(defn count-digits [num] (count (get-digits num)))

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong-number [num]
  (reduce + (for [x (get-digits num)] (exp x (count-digits num)))))

(defn armstrong? [num]
  (= num (armstrong-number num)))
