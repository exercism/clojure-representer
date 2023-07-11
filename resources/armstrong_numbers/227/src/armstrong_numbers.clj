(ns armstrong-numbers)

(defn reduce-step [size state input]
  (println state input)
  (+ state (.pow (bigdec input) size)))

(defn to-digits [num-as-str]
  (map (comp read-string str) num-as-str))

(defn calculate-armstrong-number [size num-as-str]
  (reduce (partial reduce-step size) 0M (to-digits num-as-str)))

(defn armstrong? [num]
  (let [num-str (str num)
        digits (count num-str)]
    (= (bigdec num) (calculate-armstrong-number digits num-str))))
