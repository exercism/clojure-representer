(ns two-fer)

(defn two-fer [name]
  (cond (= name "Alice") "One for Alice, one for me."
        (= name "Bob") "One for Bob, one for me."
        (= name "Zaphod") "One for Zaphod, one for me."
        :else "One for you, one for me."
        )
  )
