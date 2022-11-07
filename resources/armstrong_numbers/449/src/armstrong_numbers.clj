(ns armstrong-numbers)


(defn one-tenth 
  [input]
  (/ (- input (mod input 10)) 10)
  )

(defn pow-by-reduction [x n]
  (reduce * (repeat n x))
  )
(defn armstrong? [num]
  (== num (let [seq (map (fn [x] (mod x 10)) (take-while (fn [x] (>= x 1)) (iterate one-tenth num)))]
            (apply + (map (fn [x] (pow-by-reduction x (count seq))) seq)))))
