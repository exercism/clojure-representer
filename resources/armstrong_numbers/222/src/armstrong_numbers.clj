(ns armstrong-numbers)

(defn num-digits [num] (.length (str num)))

(defn get-digits [num-str] 
  (map #(Integer/parseInt (str %)) num-str))

(defn pow [n to] (if (= n 0) 0 (if (= to 1) n (if (= to 0) 1 
                                                (apply * (repeat to n))))))

(defn armstrong? [num] 
  (let [n (num-digits num) digits (get-digits (str num))]
    (= num (reduce + (map #(pow % n) digits))))
)
