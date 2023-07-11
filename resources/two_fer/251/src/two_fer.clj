(ns two-fer)

(defn two-fer [& [name]]
  (str "One for "
       (if (nil? name) "you" name)
       ", one for me."))
