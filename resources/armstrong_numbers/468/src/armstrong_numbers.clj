(ns armstrong-numbers)

(defn digits [num]
  (map #(Character/digit % 10) (str num)))

(defn mk-mapper [exp]
  (fn [base] (.pow (bigdec base) exp)))

(defn reduction [num]
  (let [digs (digits num)
        mapper (mk-mapper (count digs))]
    (reduce + (map mapper digs))))

(defn armstrong? [num]
  (= (bigdec num) (reduction num)))

