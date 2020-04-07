(ns two-fer)

(defn fer-2 [x] (str "One for " x ", one for me."))

(defn two-fer
  ([name] (if (empty? name)
            (fer-2 "you")
            (fer-2 name)))

  ([] (fer-2 "you")))
