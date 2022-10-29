(ns armstrong-numbers)


(defn- digits [num]
  (map #(Character/digit % 10) (str num)))

(defn- int-pow [num exponent]
  (reduce * (repeat exponent num)))

(defn armstrong? [num]
  (let [d (digits num)
        exponent (count d)]
    (->> d
         (map #(int-pow % exponent))
         (reduce +)
         (= num))))
