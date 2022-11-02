(ns armstrong-numbers)

(defn into-seq [num]
  (map
   #(Integer/parseInt %)
    (clojure.string/split (str num) #"")))

(defn expt [base exponent]
  (if (= 0 exponent)
    1
    (* base (expt base (dec exponent)))))

(defn armstrong? [num]
  (= num (reduce + (map #(expt % (count (into-seq num))) (into-seq num)))))
