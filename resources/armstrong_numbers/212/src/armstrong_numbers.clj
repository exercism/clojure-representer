(ns armstrong-numbers
  (:require [clojure.string :as str]
            [clojure.math :as math]))

(defn- make-ints [strs]
  (map #(Integer. %) strs))

(defn- split-digits [num]
  (-> num
      str
      (str/split #"")
      make-ints))

(defn armstrong? [num] ;; <- arglist goes here
  (let [digits (split-digits num)
        num-digits (count digits)]
    (->> digits
         (map #(math/pow % num-digits))
         (reduce + 0)
         int
         (= num))))