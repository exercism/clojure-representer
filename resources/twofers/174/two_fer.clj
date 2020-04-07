(ns two-fer)

(defn two-fer ;; <- arglist goes here
  ([]
   (two-fer ""))
  ([name]
   (if (empty? name)
     "One for you, one for me."
     (str "One for " name ", one for me.")))
  )
;; => #'two-fer/two-fer
;; => #'two-fer/two-fer

(two-fer "Bardia");; => "One for Bardia, one for me."

(two-fer "")
;; => "One for you, one for me."
;; => "One for you, one for me."

(two-fer)
