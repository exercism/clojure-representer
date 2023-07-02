(ns two-fer
  (:require [clojure.string :as str]))

(defn- compute-response [name]
  (str/join ["One for " name ", one for me."]))

(defn two-fer
  ([] (compute-response "you"))
  ([name] (compute-response name)))


