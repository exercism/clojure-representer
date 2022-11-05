(ns two-fer)

(def message "One for you, one for me.")

(defn two-fer
 ([] message)
 ([name] (clojure.string/replace message #"you" name)) ;; <- arglist goes here
  ;; your code goes here
  )
