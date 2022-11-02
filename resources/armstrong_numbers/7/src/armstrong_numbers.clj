(ns armstrong-numbers
   (:require [clojure.math.numeric-tower :as math])
  )

;; An Armstrong number is a number that is the sum of its own digits each raised to the power of the number of digits.

;; For example:

;; 9 is an Armstrong number, because 9 = 9^1 = 9
;; 10 is not an Armstrong number, because 10 != 1^2 + 0^2 = 1
;; 153 is an Armstrong number, because: 153 = 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153
;; 154 is not an Armstrong number, because: 154 != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190
;; Write some code to determine whether a number is an Armstrong number.

;; -----------------------------------------------------------------------------------------

;; Ran 10 tests containing 10 assertions.
;; 0 failures, 10 errors.
;; Tests failed.
;; Caused by: java.lang.IllegalStateException: Nested #()s are not allowed

#_(defn num-converter [s]
  (Integer/parseInt (str s)))

#_(num-converter 9)

#_(defn armstrong? [num]
  (= num 
     (let [num-slice (seq (str num))
           count-num (count num-slice)]
       (reduce +
        (map 
         (expt #(num-converter %) count-num)
         num-slice)
       num-slice)
       )
     )
  )

#_(armstrong? 9)

(defn num-converter [s]
  (Integer/parseInt (str s)))

(num-converter "9")

#_(defn expt
  [x n]
  (loop [prd 1 i n]
    (if (> i 0)
      (recur (* prd x) (dec i))
      prd)))

#_(expt 4 2)

(defn armstrong? [num]
  (= num
     (let [num-slice (seq (str num))
           count-num (count num-slice)]
       (reduce +
               (map
                #(math/expt (num-converter %) count-num)
                num-slice)
         )
       )
     )
  )


(armstrong? 153)
