(ns two-fer)
(require '(clojure.string))

(defn two-fer
  ([] "One for you, one for me.")
  ([name] (str "One for " (if (clojure.string/blank? name) "you" name) ", one for me."))
)
