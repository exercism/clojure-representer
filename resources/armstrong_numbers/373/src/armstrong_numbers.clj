(ns armstrong-numbers)
(require '[clojure.string :as str])

(defn exp [num e] 
  (reduce * (take e (cycle (list num))))
  )

(defn num-split [num] (map #(Integer/parseInt %) (str/split (str num) #"")))

(defn armstrong? [num] ;; <- arglist goes here
  (let [s (num-split num)] (= num (reduce + (map #(exp %1 (count s)) s)))
   ;; your code goes here
   )
)
