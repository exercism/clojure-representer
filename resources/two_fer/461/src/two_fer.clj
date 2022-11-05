(ns two-fer)

(defn two-fer [ & args] ;; <- arglist goes here
  ;; your code goes here
  (cond 
    (nil? args) "One for you, one for me."
    (empty? (first args)) "One for you, one for me."
    :else (str "One for " (first args) ", one for me.")
    )
)
