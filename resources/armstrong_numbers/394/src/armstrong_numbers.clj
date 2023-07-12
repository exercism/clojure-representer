(ns armstrong-numbers)

(defn- ** [base exp]
  (reduce * (repeat exp base)))

(defn- get-digits [n]
  (if (< n 10)
    [n]
    (conj (get-digits (quot n 10)) (rem n 10))))

(defn armstrong? [n]
  (let [digits (get-digits n)]
    (= n (reduce + (map #(** % (count (str n))) digits)))))
