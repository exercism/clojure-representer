(ns armstrong-numbers)

(require '[clojure.string :as str])

(defn str-to-int
  [s] 
  (Integer/parseInt s)
  )

(defn exp 
  [x n]
  (reduce * (repeat n x)))

(defn armstrong?
  [numb]
  (let [numb-list (map str-to-int (clojure.string/split (str numb) #""))]
    (= numb (reduce + (map #(exp % (count numb-list)) numb-list))))
  )
