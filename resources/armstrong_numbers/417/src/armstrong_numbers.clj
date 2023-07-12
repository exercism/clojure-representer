(ns armstrong-numbers)

(def digit-count (comp count str))

(defn char-to-int [c] (Character/getNumericValue c))

(defn pow [a b] (Math/pow a b))

(defn to-int-list [num]
  (->> num
       str
       seq
       (map char-to-int)))

(defn pow-all [to coll]
  (map #(pow % to) coll))

(defn armstrong? [num]
  (->> num
       to-int-list
       (pow-all (digit-count num))
       (reduce +)
       int
       (= num)))
