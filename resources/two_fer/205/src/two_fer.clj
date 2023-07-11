(ns two-fer)

(defn two-fer  ;; <- arglist goes here
  ;; your code goes here
  ([]
   "One for you, one for me.")
  ([name]
   (println name)
   (str "One for " name ", one for me.")))



(comment
   
(def sentence1 "One for you, one for me.") 
  
  
  (two-fer "Steven")
  (two-fer)
  
  )