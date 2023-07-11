(ns
 armstrong-numbers)

(defn char-> [n]
   (- (int n) 48))

(defn digits [n]
  (map char-> (str n)))

(defn get-armstrong-num
  [num]
  (reduce + (map #(.pow (bigdec %) (count (digits num))) (digits num))))

(defn armstrong? [num]
  (== num (get-armstrong-num num)))
