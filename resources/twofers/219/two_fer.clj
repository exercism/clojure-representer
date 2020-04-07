(ns two-fer
  (:require [clojure.string :as str]))

(defn two-fer [& [name]]
  (str "One for "
       (if (str/blank? name) "you" name)
       ", one for me."))
