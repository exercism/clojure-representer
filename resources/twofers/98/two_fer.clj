(ns two-fer)

; (defn two-fer [&in-name] ;; <- arglist goes here
;   (def _name (if (= (first in-name) nil) "you" (first in-name)))
;   (str "One for " _name ", one for me.")
; )


(defn two-fer
  ([]
   "One for you, one for me.")
  ([name]
   (str "One for " name ", one for me." )))