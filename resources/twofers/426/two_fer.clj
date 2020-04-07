(ns two-fer)


(defn get-name [args]
  (if (nil? args)
    "you"
    (first args)))

(defn two-fer [& args] 
  (let [ name (get-name args) ]
    (str "One for " name ", one for me.")))
