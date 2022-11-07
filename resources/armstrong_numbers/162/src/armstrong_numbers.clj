(ns armstrong-numbers)

(defn number-of-digits
  [num]
  (count (str num))
)

(defn raise-to-power
  [number power]
  (reduce * (repeat power number))
)

(defn get-number-as-list
  [num]
  (map #(Character/getNumericValue %) (str num))
)

(defn armstrong? [num]
  (= num
    (reduce +
      (map #(bigint(raise-to-power % (number-of-digits num)))
        (get-number-as-list num)
      ) 
    )
  )
)
