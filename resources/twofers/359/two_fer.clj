(ns two-fer)

(defn two-fer
  "given nothing, two-fer returns \"One for you, one for me\" "
  ([]
    "One for you, one for me.")
  "given a string name, two-fer returns
   \"One for \" name \", one for me.\""
  ([name]
   {:pre [(string? name)]}
   (if (empty? name)
     (two-fer) ;Parenthesis needed to execute. Otherwise returns function
     (str "One for " name ", one for me."))))
