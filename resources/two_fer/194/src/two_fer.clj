(ns two-fer)

(defn two-fer [& [name]] ;; <- arglist goes here
  ;; your code goes here
  (let [name (or name "you")]
    (str "One for " name ", one for me."))
)
