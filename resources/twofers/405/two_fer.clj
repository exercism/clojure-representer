(ns two-fer)

(defn two-fer [& name]
  (let [safe-name (if (empty? name) "you" (apply str name))]
    (format "One for %s, one for me." safe-name)))

;; (defn two-fer
;;   ([] (two-fer "you"))
;;   ([name]
;;    (format "One for %s, one for me." (if (empty? name) "you" name))))
