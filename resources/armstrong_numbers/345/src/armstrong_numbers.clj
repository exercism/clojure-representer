(ns armstrong-numbers)

(defn exp [x n]
  (apply * (repeat n x)))

(defn toint [x]
  (- (int x) 48))

(defn digits [x]
  (map toint (str x)))

(defn length [x]
  (count (str x)))

(defn armstrong? [num]
  (=
   num
   (reduce +
           (map
            #(exp % (length num))
            (digits num)))))
