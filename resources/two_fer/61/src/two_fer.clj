(ns two-fer)

(defn two-fer [name]
   (str "One for "
        (if (= name "") "you" name)
        ", one for me.")
   )
