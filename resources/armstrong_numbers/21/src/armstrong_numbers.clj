(ns armstrong-numbers)

(defn pow [x n]
  (reduce * (repeat (int n) (int x))))

(defn int-digits [num]
  (map #(Character/digit % 10) (str num))
)

(defn digits-raised-to-length [num]
  (let [len (count (str num))]
    (map #(pow % len) (int-digits num))
  )
)

(defn armstrong? [num]
  (= (reduce + (digits-raised-to-length num)) num)
)
