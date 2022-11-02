(ns armstrong-numbers)

(defn armstrong? [num]
  (= num (int (reduce + (map #(Math/pow % (count (str num))) (map #(Integer/parseInt %) (clojure.string/split (str num) #"")))))))
