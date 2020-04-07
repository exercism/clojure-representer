(ns two-fer)

(defn two-fer
  ([] (two-fer nil))
  ([name] (let [no-name "One for you, one for me." with-name "One for %s, one for me."]
            (if (or (nil? name) (empty? name))
              no-name
              (format with-name name)))))
