(ns armstrong-numbers)

(defn digits [n] (->> n str (map (comp read-string str))))

(defn pow [x n] (reduce * (repeat n x)))

(defn aggregate [dgts] (reduce + (map #(pow % (count dgts)) dgts)))

(defn armstrong? [num] (= num (aggregate (digits num))))
