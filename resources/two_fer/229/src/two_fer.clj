(ns two-fer)

(defn two-fer 
  "one for [you] one for me - replacing 'you' by a name if provided"
  ([] (str "One for you, one for me."))
  ([name] (str "One for ", name ", one for me.")))