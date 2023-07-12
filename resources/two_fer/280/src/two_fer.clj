(ns two-fer)
(require '[clojure.string :as string])
(defn two-fer ([name] ;; <- arglist goes here
  ;; your code goes here
  (string/join ["One for " name ", one for me."]))
  ([] "One for you, one for me."))
