(ns two-fer)

(defn two-fer 
    ([] (two-fer "you"))
    ([name] (apply str ["One for " name ", one for me."]))
)
