(ns armstrong-numbers)

(defn exp
  [x n]
  (reduce * (repeat n x)))

(defn get-digits
  [num]
  (for [n  (str num)]
    (- (byte n) 48))
  )

(defn armstrong?
  [num]
  (let [splitted-number (get-digits num)]
   (== num (reduce + (map (fn [x] (exp x (count splitted-number))) splitted-number)))
    ))