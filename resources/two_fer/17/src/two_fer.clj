(ns two-fer)

(defn two-fer ;; <- arglist goes here
  ([name] (format "%s %s%s" "One for" name ", one for me."))
  ( [] (format "%s %s%s" "One for" "you" ", one for me.")))