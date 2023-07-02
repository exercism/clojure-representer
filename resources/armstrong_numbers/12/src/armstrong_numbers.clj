(ns armstrong-numbers)

(defn- number->list [num]
  (->> num
       str
       (map (comp read-string str))))

(defn- exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num]
  (let [digits (number->list num)
        size   (count digits)
        computed (->> digits
                      (map #(exp % size))
                      (reduce +))]
    (= computed num)))




