(ns armstrong-numbers)

(defn number-of-digits [number]
      (count (str number)))

(defn armstrong-sum [number digits]
      (reduce (fn [acc n] (.add acc n))
              (BigInteger/ZERO)
              (map #(.pow (BigInteger/valueOf (.longValue (Long/parseLong %))) digits) (clojure.string/split (str number) #""))))

(defn armstrong? [num] ;; <- arglist goes here
      (let [number (BigInteger/valueOf num)
            digits (number-of-digits num)
            sum (armstrong-sum number digits)]
            (.equals number sum)))