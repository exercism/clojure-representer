(ns armstrong-numbers)

(defn exp [x n]
  (reduce * (repeat n x)))

(defn digits [str]
  (map #(- (int %) (int \0)) (seq str)))

(defn armstrong? [num]
  (let [str (print-str num)
        len (count str)]
    (->> (digits str)
         (map #(exp % len))
         (reduce +)
         (= num))))
