(ns armstrong-numbers)

(defn- to-digits
  "Returns a vector with the digits in num as integers"
  [num]
  (map #(Integer/parseInt (str %)) (str num)))

(defn armstrong? [num]
  (let [digits (to-digits num)
        n (count digits)
        sum (->> digits
                 (map #(.pow (biginteger  %) n))
                 (apply +))]
    (= num sum)))
