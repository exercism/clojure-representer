(ns two-fer
  (:require clojure.string))

(defn two-fer
  ([]
   (two-fer ""))
  ([name]
   (let [trimmed-name (clojure.string/trim name)
         address-name (if (= trimmed-name "")
                        "you"
                        trimmed-name)]
     (str "One for " address-name ", one for me."))))

(comment
  (two-fer "Bob")
  (two-fer "")
  (two-fer))
