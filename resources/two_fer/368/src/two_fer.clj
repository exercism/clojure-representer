(ns two-fer)

(defn- one-for 
  [x]
  (str "One for " x ", one for me."))

(defn two-fer 
  ([] (one-for "you")) 
  ([name] (one-for name)) 
)
