(ns armstrong-numbers)

(defn into-seq [num]
  (map
   #(Integer/parseInt %)
    (clojure.string/split (str num) #"")))

(defn exp [base exponent]
  (if (= 0 exponent)
    1
    (* base (exp base (dec exponent)))))

(defn armstrong? [num]
  (= num (reduce + (map #(exp % (count (into-seq num))) (into-seq num)))))
