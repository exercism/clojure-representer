(ns armstrong-numbers)

(defn get-digits [number]
  (map #(Character/getNumericValue %) (str (bigint number))))

(defn pow [val exp]
  (reduce * (repeat exp val)))

(defn armstrong? [num]
  (let [
        digits (get-digits num)
        num-digits (count digits)
        powers (map #(bigint (pow % num-digits)) digits)
        sum-power (apply + powers)
       ]
        ;;digits
        ;;num-digits
        ;;powers
        ;;sum-power
        (= num sum-power)
    ))


