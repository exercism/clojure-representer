(ns armstrong-numbers)

(defn as-parts
  ([num] (as-parts num [] 10))
  ([num r c]
   (let [v (mod num c)]
     (if (pos? num)
       (as-parts (- num v) (conj r (/ v (/ c 10))) (* c 10))
       r))))

; https://stackoverflow.com/a/5058544
(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num]
  (let [parts (as-parts num) pow (count parts)]
    (if (= num 0) true
        (= num (apply + (map #(exp % pow) parts))))))


