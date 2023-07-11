(ns armstrong-numbers)

(defn pow [x y]
  (if (zero? y) 1
   (reduce * (repeat y x))
  ))

(defn armstrong? [num] 
  (= num (reduce + (map (fn [x] (pow x (count(str num)))) (map #(Integer/parseInt %) (map str (seq(str num)))))))
)

