(ns armstrong-numbers)

(defn exp
  [number n]
  (reduce * (repeat n number)))

(defn armMap
  "Takes a number and returns a destructured sequence of it's integers"
  [number]
  (def size (count (str number)))
  (->> number
      (str) ;; toString()
       (partition 1) ;; split all ints
       (flatten) ;; remove layers of list from the split elements to a single layer
       (map #(Character/digit % 10)) ;; maps a char == digit back to an int
       (map #(exp % size)) ;; number ^ size
       (reduce +)) ;; add everything together
  )

(defn armstrong? 
  "Determine if a given number is an Armstrong number"
  [number]
  (== number (armMap number))
)
