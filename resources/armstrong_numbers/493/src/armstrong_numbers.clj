(ns armstrong-numbers)

(defn digits [num]
  (loop [num num
         tail []]
    (let [remaining (int (/ num 10))
          last      (int (mod num 10))]
      (if (= remaining 0)
        (conj tail last)
        (recur remaining (conj tail last))))))

(defn exp [num exp]
  (loop [acc 1 exp exp]
    (if (zero? exp)
      acc
      (recur (* acc num) (dec exp)))))

(defn armstrong? [num]
  (let [digits (digits num)
        num-digits (count digits)
        sum (reduce + (map #(exp % num-digits) digits))]
    (= num sum)))

(defn -main [& args]
  (println (armstrong? 153)))