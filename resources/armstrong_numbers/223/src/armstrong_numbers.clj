(ns armstrong-numbers)

(defn chat->int [c]
  (- (int c) 48))

(defn digits [n]
  (map chat->int (str n)))

(defn calc [ds]
  (biginteger (reduce + (map #(.pow (biginteger %) (count ds)) ds))))

(defn armstrong? [num]
  (= num (-> num digits calc)))


