(ns armstrong-numbers)

(defn to-list [num acc]
  (if (= num 0)
    acc
    (to-list (quot num 10)
             (cons (rem num 10)
                   acc))))

(defn calc-armstrong [num]
  (let [digits-list (to-list num '())
        len (count digits-list)]
    (long (reduce #(+ (Math/pow %2 len) %1)
                  0
                  digits-list))))

(defn armstrong? [num]
  (= (calc-armstrong num) num))
