(ns two-fer)

(defn two-fer [& [name]] ;; <- arglist goes here
  (if (nil? name)
    "One for you, one for me."
    (str "One for " name ", one for me."))
)

(comment (
           (two-fer "Max")
           ))