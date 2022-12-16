(ns two-fer
  (:require [clojure.string :as str]))

(def s "One for _ and one for me")

(defn two-fer [& {:keys [name] :or {name "you"}}]
  (str/replace s "_" name)
  )

(two-fer)