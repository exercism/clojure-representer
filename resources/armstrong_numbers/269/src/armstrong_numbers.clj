(ns armstrong-numbers)

(defn char-to-int [char]
  (Integer/parseInt (str char)))

(defn pwr [x i]
  (last (take i (iterate #(* x %) x))))

(defn calculate-armstrong [num]
  (let [nums (map char-to-int (str num))
        power (count nums)]

    (reduce (fn [acc i]
              (+ acc (pwr i power)))
            0
            nums)))

(defn armstrong? [num]
  (= num (calculate-armstrong num)))
