(ns armstrong-numbers)

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num]
  (->>
    (for [n  (str num)] 
      (->>
      (count (str num))
      (exp (long (- (byte n) 48)))
      (long)
      ))    
    (reduce +)
    (== num)
  )
)
