(ns two-fer)

(defn two-fer [& args]
  (let [res "One for you, one for me."
        name (first args)]
    (if (some? name)
      (clojure.string/replace res #"you" name)
      res)))
