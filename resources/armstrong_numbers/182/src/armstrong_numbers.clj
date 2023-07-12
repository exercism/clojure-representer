(ns armstrong-numbers
  (:require [clojure.string :as str]
            [clojure.math.numeric-tower :as math]))

(defn to-int [s] (Integer/parseInt s))

(defn digit-list [num] (map to-int (str/split (str num) #"")))
(comment
  (digit-list 132654))

(defn armstrong-value
  [num]
  (let [dig-list (digit-list num)]
    (long (apply + (map #(Math/pow % (count dig-list)) dig-list)))))

(comment
  "Test values" ; expected value
  (armstrong-value 123) ;36
  (armstrong-value 56430) ;12168
  (armstrong-value 9351)  ;7268
  (armstrong-value 7) ;7
  (armstrong-value 39) ;90
  (armstrong-value 405) ;189
)

(defn armstrong?
  [num] ;; <- arglist goes here
  (= num (armstrong-value num))
)

(comment
  ;; alles Armstrong Zahlen:
  (map armstrong? '(153 1 2 3 4 5 6 7 8 9))
  (map armstrong? '(10 11 150 630))

  )
