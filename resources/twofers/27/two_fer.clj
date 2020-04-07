(ns two-fer)

(defn two-fer [&[name]]
  (format "One for %s, one for me." (if (nil? name) "you" name))
)

