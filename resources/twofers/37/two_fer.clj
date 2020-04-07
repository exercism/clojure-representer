(ns two-fer
  (require [clojure.string :as string]))

(defn two-fer ;; <- arglist goes here
  ([]
   (two-fer "you"))
  ([name]
   (string/join "" ["One for " name  ", one for me."])))
