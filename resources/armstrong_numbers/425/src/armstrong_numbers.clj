(ns armstrong-numbers)

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [arr (clojure.string/split (str num) #"")]
    (= num (reduce + (map #(.pow (biginteger %) (count arr)) arr)))))
