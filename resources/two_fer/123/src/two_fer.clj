(ns two-fer)

(defn two-fer [name] ;; <- arglist goes here
  (when (some? name)
    true
    false)
)
