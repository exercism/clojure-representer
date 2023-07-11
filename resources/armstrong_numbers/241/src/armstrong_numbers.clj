(ns armstrong-numbers)

(defn- digits
  [num]
  (if (< num 10)
    [num]
    (conj (digits (quot num 10)) (rem num 10))))

(defn- pow
  [num pow]
  (reduce * (repeat pow num)))

(defn armstrong? [num] 
  (let [digits (digits num)
        size   (count digits)]
    (->> digits
         (map (fn [digit] (pow digit size)))
         (reduce +)
         (= num))))
