(ns armstrong-numbers)

(defn pow [x n] 
 (reduce * (repeat n x)))

(defn digits [num]
  (->> num str (map (comp read-string str))))

(defn digits-power-sum [num]
 (let [digits% (digits num)]
  (->> digits%
   (map #(pow % (count digits%))) 
   (reduce +))))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (= num (digits-power-sum num)))
