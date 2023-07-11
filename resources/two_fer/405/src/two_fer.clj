(ns two-fer)

;; https://stuartsierra.com/2015/06/01/clojure-donts-optional-arguments-with-varargs
(defn two-fer
  ([] "One for you, one for me.")
  ([name] (str "One for " name ", one for me."))
)
