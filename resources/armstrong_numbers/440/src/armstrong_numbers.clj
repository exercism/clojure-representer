(ns armstrong-numbers)

(defn digits [n]
  (->> n str (map (comp read-string str))))

(defn pow [b e]
  (reduce * (repeat e b)))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [ds (digits num)
        exp (count ds)]
    (->> (map #(pow % exp) ds)
         (reduce +)
         (= num))))


