(ns armstrong-numbers
  (:require [clojure.string :as str]))

(defn pow
  [x n]
  (reduce * (repeat n x)))

#_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
(defn armstrong?
  [num]
  (let [digits (str/split (str num) #"")
        f (comp bigint
                #(pow % (count digits))
                #(Integer/parseInt %))]
    (->> (map f digits)
         (reduce +)
         (= num))))
