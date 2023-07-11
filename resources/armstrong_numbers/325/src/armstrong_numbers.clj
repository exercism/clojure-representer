(ns armstrong-numbers)

(defn digits [n] (->> n str (map (comp read-string str))))

(defn pow-helper [n x p]
  (if (== p 1) n (pow-helper (* n x) x (- p 1))))

(defn pow [n p]
  (pow-helper n n p))

(defn armstrong-sum [num]
  (let [d (digits num) c (count d)]
    (reduce + (map (fn [n] (pow n c)) d))))

(defn armstrong? [num] ;; <- arglist goes here
  (= num (armstrong-sum num)))
