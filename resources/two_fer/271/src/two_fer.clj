(ns two-fer)

(defn two-fer;; <- arglist goes here
  ;; your code goes here
  ([] (two-fer "you"))
  ([name] (clojure.string/join "" ["One for " name ", one for me."]))
)
