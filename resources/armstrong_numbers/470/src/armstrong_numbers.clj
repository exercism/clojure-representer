(ns armstrong-numbers)

(defn exp
  [x y]
  (if (= y 0)
    1
    (* x (exp x (dec y)))))

(defn get-digits
  ([num] (get-digits num '()))
  ([num acc] (if (= num 0)
               acc
               (recur
                (long (/ num 10))
                (cons (mod num 10) acc)))))

(defn armstrong? [num]
  (let [digits (get-digits num)
        exponentiated (map (fn [digit]
                             (exp digit (count digits)))
                           digits)
        sum (reduce + exponentiated)]
    (= sum num)))
