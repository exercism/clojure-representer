(ns two-fer)

(defn two-fer 
  ([& name] ;; <- arglist goes here
  (cond (and (not (empty? name)) (= (count name) 1)) (str "One for " (first name) ", one for me.")
        :else (str "One for you, one for me."))))