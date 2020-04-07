(ns two-fer)

(defn two-fer  ;; <- arglist goes here
  ;; your code goes here
  ([] "One for you, one for me.")
  ([name] (let [n (if (empty? name) "you" (str name))]
  (str "One for " n ", one for me.")))
)
