(ns armstrong-numbers)

(defn pow
  [b e]
  (reduce * 1 (repeat e b))
)

(defn digitize
  [num]
  (
    loop
    [remnum num digits []]
    (
      if
      (= remnum 0) digits
      (recur (quot remnum 10) (conj digits (mod remnum 10)))
    )
  )
)

(defn armstrong?
  [num]
  (
    let
    [digits (digitize num) ndigits (count digits)]
    (= num (reduce + 0 (map #(pow % ndigits) digits)))
  )
)
