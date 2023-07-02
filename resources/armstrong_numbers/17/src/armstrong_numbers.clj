(ns armstrong-numbers)

(defn- char->int [char]
  (Character/digit char 10))

(defn armstrong? [n]
  (let [string (str n)
        length (count string)
        digits (map char->int (seq string))]
    (->> digits
         (map biginteger)
         (map #(.pow % length))
         (reduce +)
         (= n))))
