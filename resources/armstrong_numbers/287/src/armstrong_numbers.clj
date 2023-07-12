(ns armstrong-numbers)

(defn digits
  [number]
  (map #(Character/digit % 10) (str number)))

(defn armstrong?
  [num]
  (if (= num (biginteger (reduce + (map (fn [n]  (Math/pow n (count (digits num)))) (digits num))))) true false))