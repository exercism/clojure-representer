(ns armstrong-numbers)

(defn armstrong? [num]
  (let [power (count (str num))
        sum-of-digits-to-power (reduce +
                                 (for [n (str num)]
                                   (reduce *
                                     (repeat power (Character/getNumericValue n)))))]
    (= num sum-of-digits-to-power)))
