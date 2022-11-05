(ns two-fer)

;; (defn two-fer [& [name]]
;;   (format "One for %s, one for me." (or name "you")))

(defn two-fer
  ([] "One for you, one for me.")
  ([name] (format "One for %s, one for me." name)))
