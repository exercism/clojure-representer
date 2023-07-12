(ns armstrong-numbers)

(defn num-digits [num]
  (if (> num 0) 
      (inc (num-digits (quot num 10)))
      0
  )
)

(def big-ten (biginteger 10))

(defn armstrong-sum [num power]
  (if (> num 0) 
      (.add (.pow (.remainder num big-ten) power) (armstrong-sum (.divide num big-ten) power))
      (biginteger 0)
  )
)

(defn armstrong? [num]
  (== num (armstrong-sum (biginteger num) (num-digits num)))
)