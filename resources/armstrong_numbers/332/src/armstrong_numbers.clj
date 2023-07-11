(ns armstrong-numbers)

(require '([clojure.string :as str]))
;;(:require  [clojure.set :as set] [clojure.string :as str])


(defn to-digits [n]
  "converts number to digits e.g 19 becomes [1 9]"
  (map #(read-string (str %)) (str n)))


(defn calc-power
  "calculate armstrong value"
  [digit digit-count]
  (def o (Math/pow digit digit-count))
  ;; (+ total o)
   (identity (java.lang.Math/round o) )
  )



(defn armstrong?
  [num]

  (def digits (reduce conj [] (to-digits num)))
  (def digit-count (count digits))

  (def calc-power2 #(java.lang.Math/round (Math/pow %1 digit-count)) )
 ;; (def calc-power2 #( Math/pow (BigInteger. (str %1) ) digit-count) )


  (println (str "num: " num))
  (println (str "digit  array: " digits))
  (println (str "count: " digit-count))




  (def transform  (reduce conj []  (map calc-power2 digits)) )

     (println (str "transform: " transform))


  (def result (apply + transform))

  (println (str "result: " result))


  (if (= num result)
    true
    false
    )
 )
