(ns two-fer
  (:require [clojure.string :as str]))

(defn two-fer [& name]
  (let [name (if (nil? name)
               "you"
               (first name))]
    (str/join ["One for " name ", one for me."])))
