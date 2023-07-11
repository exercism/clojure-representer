(ns armstrong-numbers)

(defn my-power [num n]
  (reduce * (repeat n num)))

(defn armstrong? [num]
  (let [list-numbers (->> num
                          str
                          (map (comp read-string str)))
        numbers-qty  (count list-numbers)
        result       (->> list-numbers
                          (map #(my-power % numbers-qty))
                          (reduce +))]
    (= num result)))
