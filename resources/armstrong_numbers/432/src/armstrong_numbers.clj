(ns armstrong-numbers)

(defn exp [digit n]
  "Takes a digit and length of num and returns the exponent, which is the digit raised to length"
  (reduce *(repeat n digit)))

(defn armstrong? [num]
  "Takes a num and determines whether a number is an Armstrong number"
  (let [digits (map #(read-string (str %)) (str num))
        len (count digits)]
    (= num (reduce + (map #(exp % len) digits)))
  )
)