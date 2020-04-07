(ns two-fer
  (:require [clojure.string :as string]))


(defn sentence [& coll]
  (let [[first-char & remaining-chars] (string/join ", " coll)]
    (str (string/upper-case first-char)
         (apply str remaining-chars)
         ".")))


(defn one-fer
  ([]
   (one-fer "me"))

  ([name]
   (string/join " " ["one for" name])))


(defn two-fer
  ([]
   (two-fer "you"))

  ([name]
   (sentence (one-fer name)
             (one-fer))))


(defn two-fer-unflexible
  ([]
   (two-fer-unflexible "you"))

  ([name]
   (str "One for " name ", one for me.")))
