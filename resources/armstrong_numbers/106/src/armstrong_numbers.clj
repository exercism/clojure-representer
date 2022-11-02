(ns armstrong-numbers)

(defn power [base exp]
  (if (= exp 0)
    1
    (* base (power base (- exp 1)))))

(defn char-to-int [c]
  (- (int c) 48))

(defn armstrong? [num]
  (let [s (str num)
        n (count s)]
    (= num (reduce + (map (fn [c] (power (char-to-int c) n)) s)))))
