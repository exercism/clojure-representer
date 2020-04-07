(ns exercism.clojure-representer)

(defn -main
  "Grabs a twofer by number."
  [n]
  (slurp (str "resources/twofers/" n "/two_fer.clj")))

(comment
  (-main 0)
  )