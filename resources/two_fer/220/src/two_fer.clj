(ns two-fer)

(defn two-fer
  ([] (two--fer "you"))
  ([name] (two--fer name)))

(defn two--fer [name]
  (clojure.string/join ["One for " name ", one for me."]))
