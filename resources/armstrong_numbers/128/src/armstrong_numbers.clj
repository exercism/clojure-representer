(ns armstrong-numbers)

(defn armstrong? [num]
      (let [num (count (str num))
            power-seq (map #(int (Math/pow (Character/digit % 10) num)) (seq (str num)))
            power-seq-sum (apply + power-seq)]
           (= power-seq-sum num)))
