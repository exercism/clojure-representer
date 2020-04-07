(ns two-fer)
 
 (defn two-fer 
   ;[name]
   ;[& {:keys [name]} :or { name "you"}] ;; <- arglist goes here
   [& {:keys [name]  :or {name "you"}}]
   (str "One for " name ", one for me.")
   )
