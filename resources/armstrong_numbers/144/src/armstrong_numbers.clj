(ns armstrong-numbers)

(defn list-digits [num]
  (map (comp read-string str) (str num)))

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong?
  "calculates if integer belongs to armstrong set"
  [num]
  (let [digits (list-digits num)]
    (= num (reduce
      #(+ %1 (exp %2 (count digits)))
      0 digits))))