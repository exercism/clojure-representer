(ns armstrong-numbers)

(defn- toIntList [num] 
  (map #(Character/digit % 10) (str num))
)

(defn- ** [x n] (reduce * (repeat n x)))

(defn- calcDigit [value power] (** value power))

(defn- getArmstrongDigits [num] (map (fn [v] (calcDigit v (count (str num)))) (toIntList num)))

(defn armstrong? 
  ([num] (= num (reduce + (getArmstrongDigits num))))
  ([] false)
)
