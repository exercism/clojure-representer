(ns two-fer)

(defn two-fer [name]
  (if (nil? name)
    "One for me, one for you."
    (if (> (count name) 0)
      (str "One for " name ", one for you"))))

