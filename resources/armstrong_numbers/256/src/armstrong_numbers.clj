(ns armstrong-numbers )

(defn digits-of-number [value]
  (->> (str value)
       (map (comp #(- % 48) int))))

(defn armstrong-number [value]
  (let [l (digits-of-number value)]
    (->> l 
         (map #(.pow (biginteger %1) (count l)))
         (apply +)
         )))
(defn armstrong? [num]
  (= num (armstrong-number num)))