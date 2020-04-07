(ns two-fer)

(defn two-fer ;; <- arglist goes here
  ([]
    (str "One for you, one for me."))
  ([name]
  (if (clojure.string/blank? name )
    (str "One for you, one for me.")
    (str "One for " name ", one for me.")))
)
