(ns two-fer
  (:require [clojure.string :as str]))

(defn two-fer [name]
  (str/join ["One for " name ", one for me."]))