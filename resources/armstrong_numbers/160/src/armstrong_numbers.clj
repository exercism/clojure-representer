(ns armstrong-numbers)

(defn count-digits
  "Counts to amount of digits of a given number"
  [num]
  (count (map read-string (map str (seq (str num))))))

(defn separate-digits
  "Makes a list of digits from any number"
  [num]
  (map read-string (map str (seq (str num)))))

(defn exp
  "Raise x to the nth power"
  [x n]
  (loop [n n acc 1]
    (if (zero? n)
      acc
      (recur (dec n) (* acc x)))))

(defn armstrong?
  "An Armstrong number is a number that is the sum of its own digits 
   each raised to the power of the number of digits."
  [num]
  (= num 
     (apply + 
            (for [i (range (count-digits num))] 
              (exp 
               (int (nth (separate-digits num) i)) 
               (count-digits num))))))

