(ns armstrong-numbers)

(defn pow [a b] (reduce * 1 (repeat b a)))
(defn digits [num] (->> num
                        str
                        (map (comp read-string str))))

(defn armstrong? [num] ;; <- arglist goes here
  (= num
     (reduce +
             (map #(pow % (count (str num)))
                  (digits num))))
)
