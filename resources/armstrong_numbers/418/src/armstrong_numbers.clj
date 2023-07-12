(ns armstrong-numbers)

(defn digits [n]
  (if (< n 10)
    [n]
    (conj (digits (quot n 10)) (rem n 10))))

(defn pow [x n]
  (reduce * (repeat x n)))

(defn compute [exp numbers]
  (map #(pow exp %) numbers))

(defn vector-to-len-pow [numbers]
  (compute (count numbers) numbers))

(defn armstrong? [n] ;; <- arglist goes here
  ;; your code goes here
  (let [d (digits n)
        s (reduce + (vector-to-len-pow d))]
    (= n s))
)
