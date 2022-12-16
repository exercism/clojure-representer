(ns two-fer)

(defn two-fer 
  ([]
   "One for you, one for me.")
  ([name] 
   (if (clojure.string/blank? name) 
     (two-fer)
     (str "One for " 
          (clojure.string/trim name) 
          ", one for me."))))
