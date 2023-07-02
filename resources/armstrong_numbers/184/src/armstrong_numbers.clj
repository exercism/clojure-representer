(ns armstrong-numbers
(require [clojure.edn :as edn :refer [read-string]])
(require [clojure.math.numeric-tower :as math :refer [expt]]))

(use 'clojure.string)
(defn armstrong? [num] 
  (let [digits
        (map #(read-string %) (split (str num) #""))]
    (=
     (reduce + (map #(expt % (count digits)) digits))
     num)))
