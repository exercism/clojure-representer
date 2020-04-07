(ns two-fer
  (:require [clojure.string :as str]))

(defn two-fer
  [& name]
  (let
    [s (if name (str/join name) "you")]
    (format "One for %s, one for me." s)))

