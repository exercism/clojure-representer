(ns two-fer)

(defn two-fer
  ([]
   (two-fer "you"))
  ([other-person]
   (let [prefix "One for"
         mid (clojure.string/join "" [other-person ","])
         postfix "one for me."]
     (clojure.string/join
      " "
      [prefix mid postfix]))))
