(ns armstrong-numbers)

(defn to-digits
  [n]
  (->> n str (map (comp read-string str))))

(defn exp
  [x n]
  (reduce * (repeat n x)))

(defn armstrong?
  [num]
  (let [digits (to-digits num)]
    (->> (map #(exp % (count digits)) digits)
         (reduce +)
         (= num))))

(armstrong? 153)
