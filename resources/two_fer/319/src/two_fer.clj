(ns two-fer
  (:require [clojure.string :as string]))

(defn two-fer ;; <- arglist goes here
  ;; your code goes here
  ([] (str "One for you, one for me."))
  ([name] (string/join "" ["One for " name ", one for me."])))
