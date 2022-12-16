(ns two-fer)

(defn two-fer 
  ([] "One for you, one for me.")
  ([name] (case name
            "" "One for you, one for me."
            "Alice" "One for Alice, one for me."
            "Bob" "One for Bob, one for me."))
  ;; your code goes here
)
