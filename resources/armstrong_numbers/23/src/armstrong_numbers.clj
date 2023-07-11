(ns armstrong-numbers
  (:require [clojure.string :as str]))

;; defn split-number-into-digits

(defn exp [x n]
     (if (zero? n) 1
         (* x (exp x (dec n)))))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [nums (str/split (str num) #"")
        digit-count (count nums)] 
    
    (= num (reduce + (map #(exp (Long/parseLong %) digit-count) nums ))))
)



