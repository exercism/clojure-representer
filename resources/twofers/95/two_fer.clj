(ns two-fer)
(use '[clojure.string :only (join)])

(defn two-fer
([] "One for you, one for me.")
([name] (join ["One for " name ", one for me." ]))  
)
