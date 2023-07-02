(ns armstrong-numbers)

(defn digits [num]
  (->> num str (map (comp read-string str))))

(defn exp [num power]
  (reduce * (repeat power num)))

(defn armstrong? [num]
  (let [d (digits num)
        num-digits (count d)]
    (= (reduce + (map #(exp % num-digits) d)) num))
)
