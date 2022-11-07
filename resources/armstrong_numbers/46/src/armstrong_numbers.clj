(ns armstrong-numbers)

(defn num-digits
  [num]
  (if (= num 0) 1
    (inc (int (Math/log10 num)))))

(defn digit-at-position
  [num pos]
  (Character/digit (nth (seq (str num)) pos) 10))

(defn exp [x n]
  (loop [acc 1 n n]
    (if (zero? n) acc
        (recur (* x acc) (dec n)))))

(defn armstrong-value-of-digit
  [num pos]
  (exp (digit-at-position num pos) (num-digits num)))

(defn armstrong-sum
  [num]
  (loop [digit-position 0
         acc 0]
    (if (< digit-position (dec (num-digits num)))
      (recur (inc digit-position)
             (+ acc (armstrong-value-of-digit num digit-position)))
      (+ acc (armstrong-value-of-digit num digit-position)))))

(defn armstrong?
  [num]
  (= (armstrong-sum num) num))
