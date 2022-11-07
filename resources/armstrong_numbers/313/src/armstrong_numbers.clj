(ns armstrong-numbers)

(defn num->digits 
        "Little endian"
        [num]
        (if (< num 10) (list num)
            (cons (rem num 10) (num->digits (quot num 10)))))

(defn exp [b e] (apply * (repeat e b)))

(defn armstrong? [num]
  (let [digits (num->digits num)]
    (= num (apply + (map #(exp % (count digits)) digits)))))
