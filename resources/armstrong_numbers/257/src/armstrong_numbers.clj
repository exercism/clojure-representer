(ns armstrong-numbers)
(require '[clojure.string :as str])

(defn armstrong? [num] ;; <- arglist goes here
  (let [digits (map #(Integer/parseInt %) (str/split (str num) #""))
        expt (count digits)]
    (== num (reduce + (map #(.pow (bigdec %) expt) digits)))))
