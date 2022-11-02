(ns armstrong-numbers)

(defn armstrong [num]
  (reduce + (map (fn [digit] (reduce * (repeat (count (str num)) digit))) (map biginteger (clojure.string/split (str num) #"")))))

(defn armstrong? [num] ;; <- arglist goes here
  (= num (armstrong num)
     )
  )
