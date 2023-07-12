(ns armstrong-numbers)

(defn- pow [a b]
  (cond
    (zero? b) 1
    (even? b) (pow (* a a) (quot b 2))
    :else (* a (pow a (dec b)))))

(defn- aux
  [curr acc len]
  (if (= 0 curr)
    acc
    (aux (quot curr 10) (+ acc (pow (rem curr 10) len)) len)))

(defn armstrong? [num] (= num (aux num 0 (count (str num)))))
