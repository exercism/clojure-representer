(ns armstrong-numbers)

(defn digits [n]
  (->> n str (map (comp read-string str))))

(defn exp [x n]
  (reduce * (repeat n x)))

(defn exp-digits [n]
  (let [digits (digits n)
        count  (count digits)]
    (map #(exp % count)
         digits)))

(defn armstrong? [n]
  (->> (exp-digits n)
       (reduce +)
       (= n)))