(ns armstrong-numbers)

(defn non-neg-power [n k]
  (if (zero? k) 1
    (* n (non-neg-power n (- k 1)))
    )   
)

(defn list-of-digits  [n]
  (map #(Integer/parseInt %) (clojure.string/split (str n) #"(?=[0-9])"))
)

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let  [dlist (list-of-digits num)]
    (let [k (count dlist)]
        (= (reduce + (map #(non-neg-power % k) dlist)) num)
      )
    )
)
