(ns armstrong-numbers)

(defn armstrong? [num]
  (reduce * (repeat (count (str num)) num))
)
