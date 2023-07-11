(ns two-fer)

;; The way to do this in Clojure
;; is to pattern match different argument numbers.
(defn two-fer
  ([] "One for you, one for me.")
  ([name] (str "One for " name ", one for me.")))
