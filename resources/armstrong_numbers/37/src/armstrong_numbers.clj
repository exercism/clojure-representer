(ns armstrong-numbers)

(defn tokenize-int
  [n]
  (map #(Character/digit %1 10) (str n)))

(defn pow-n
  [n num]
  (apply * (repeat n num)))

(defn armstrong? [num]
  (let [num-seq (tokenize-int num)
        pow     (partial pow-n (count num-seq))]
    (or
     (< num 10)
     (= num (apply + (map pow num-seq))))))

