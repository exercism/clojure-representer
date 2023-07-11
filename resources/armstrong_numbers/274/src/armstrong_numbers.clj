(ns armstrong-numbers)

(require '[clojure.string :as str]
         '[clojure.edn :as edn])

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [input-number]
  (let [number-as-string (str input-number)
        num-digits (count number-as-string)
        digits (map #(edn/read-string %) (str/split number-as-string #""))
        powered-digits (map #(exp % num-digits) digits)
        sum (reduce + powered-digits)]
    (= sum input-number)
    )
)
