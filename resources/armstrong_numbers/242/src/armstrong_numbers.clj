(ns armstrong-numbers)

(defn armstrong? [num]
  (->>
    (for [n  (str num)] 
      (->>
      (count (str num))
      (Math/pow (- (byte n) 48))
      ))    
    (reduce +)
    (== num)
  )
)
