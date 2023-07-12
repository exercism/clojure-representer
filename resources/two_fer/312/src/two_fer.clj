(ns two-fer (:require [clojure.string :as str]))

(defn two-fer
  ([] (two-fer "you"))
  ([name]
   (str "One for "
        (cond
          (str/blank? name) "you"
          :else name)
        ", one for me.")))