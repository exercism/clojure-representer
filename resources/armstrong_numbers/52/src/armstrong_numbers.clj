(ns armstrong-numbers)

(defn create-character-list [length x] (for [item length] x))
(defn multiply-by-length [character length] (reduce * (create-character-list (range length) character)))
(defn armstrong? [num]
  (def num-string (str num))
  (def num-string-length (count num-string))
  (def result (reduce (fn [accumulator character] (+ accumulator (multiply-by-length (Character/digit character 10) num-string-length))) 0 num-string))
  (== num result))
