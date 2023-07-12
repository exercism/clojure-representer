(ns two-fer
  (:require [clojure.pprint :refer [cl-format]]))

(defn two-fer
  ([] (two-fer nil))
  ([name] (cl-format nil "One for ~:[you~;~:*~A~], one for me." name)))
