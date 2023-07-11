(ns armstrong-numbers)
(require '[clojure.string :as str])

(defn exp [num power]
  (reduce * (repeat power num)))

(defn armstrong? [num] ;; <- arglist goes here
  (-> num
      (str)
      (str/split #"")
      ((fn [n] (map (fn [n] (Integer/parseInt n)) n)))
      ((fn [n] (map (fn [n] (exp n (count (str num)))) n)))
      ((fn [n] (reduce + n)))
      (= num)))
