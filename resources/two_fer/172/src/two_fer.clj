(ns two-fer)

(defn two-fer  ;; <- arglist goes here
  ;; your code goes here
  ([] (two-fer nil))
  ([name] 
   (let [phrase "One for you, one for me."]
    (if (nil? name)
    phrase
    (clojure.string/replace phrase "you" name))
    )))
