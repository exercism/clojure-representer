(ns two-fer)
(defn two-fer  ;; <- arglist goes here
  ([name] ( cond 
            (= name "Alice") "One for Alice, one for me."
            (= name "Bob") "One for Bob, one for me."
            :else "One for you, one for me."))
  ([] "One for you, one for me."))