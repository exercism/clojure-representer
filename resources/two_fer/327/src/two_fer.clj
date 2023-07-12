(ns two-fer)
(require '[clojure.string :as str])

(defn two-fer
  ([] (two-fer nil))
  ([name]  ;; <- arglist goes here
  ;; your code goes here
   (str "One for " (if (str/blank? name) "you" name) ", one for me.")))
