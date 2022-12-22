(ns two-fer)
(require '[clojure.string :as str])
(defn two-fer 
  ([]
   (str "One for you, one for me."))
  ([name] ;; <- arglist goes here
  (str "One for " name ", one for me."))
)
