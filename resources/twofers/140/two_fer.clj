(ns two-fer)

(defn two-fer
  ([] "One for you, one for me.")
  ([name] (clojure.string/join (concat "One for " name ", one for me."))))

(defn -main [& args]
  (println (if (first args)
             (two-fer (first args))
             (two-fer))))
