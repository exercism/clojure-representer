(ns two-fer)

(defn two-fer ;; <- arglist goes here
  ;; your code goes here
  ([] (two-fer "you"))
  ([name] (format "One for %s, one for me." (if (nil? name) "you" name))))

(comment
  (two-fer nil)
  (two-fer "Lupo")
  )