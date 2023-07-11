(ns armstrong-numbers)

(defn digits
  [number]
  (map (fn [c] (- (int c) 48))  (str number))
)

(defn sum-digits [num]
  (let [d (digits num)]
    (let [cdigits (count d)]
      (->>
        d
        (map #(reduce * (repeat cdigits %)))
        (reduce +)
        )
      ))
  )

(defn armstrong? [num]
  (= num (sum-digits num))
  )
