(ns armstrong-numbers)

(defn armstrong? [num] ;; <- arglist goes here
    (def lieszeeche (clojure.string/split (str num) #""))
    (def zuel (map #(Integer/parseInt %) lieszeeche))
    (= num (reduce +(map #(reduce *(repeat (count zuel) %)) zuel)))
)
