(ns armstrong-numbers)

(defn- pow
  "Returns integer number of x to the power of n"
  [x n]
  (reduce * (repeat n x)))

(defn armstrong?
  "Provides a way to validate whether or not a number is an Armstrong number"
  [num]
  (->> (str num)
       (map #(Character/getNumericValue %))
       (map #(pow % (count (str num))))
       (reduce +)
       (= num)))