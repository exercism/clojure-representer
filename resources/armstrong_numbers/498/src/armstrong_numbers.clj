(ns armstrong-numbers)

(defn exp [x n]
  (loop [acc 1
         n n]
    (if (= n 0) acc
        (recur (* x acc) (dec n)))))

(defn extract [x n]
  (int (/ (mod x (exp 10 n)) (exp 10 (dec n)))))

(defn num-to-vector [x]
  (loop [acc [] pos 1]
    (let [acc2 (conj acc (extract x pos))]
      (if (< x (exp 10 pos)) acc2
          (recur acc2 (inc pos))))))

(defn sum-digit [x]
  (let [digits (num-to-vector x) len (count digits)]
    (loop [ds digits acc 0]
      (if (empty? ds) acc
          (recur (rest ds) (+ acc (exp (first ds) len)))))))

(defn armstrong? [num]
  (= num (sum-digit num))
  )
