(ns two-fer)

#_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
(defn two-fer
  ([]
   "One for you, one for me.")
  ([name]
   (str "One for " name ", one for me.")))
