(ns armstrong-numbers)

(defn- power-of
  [num pow]
  (loop [acc num
         times pow]
    (if (= times 1)
      acc
      (recur (* acc num) (dec times)))))

(defn digits-count
  [num]
  (count (.toString num)))

(defn digits
  [num]
  (loop [acc []
         remaining (bigint (/ num 10))
         n (mod num 10)]
    (if (< remaining 1)
      (conj acc n)
      (recur (cons n acc)
             (bigint (/ remaining 10))
             (mod remaining 10)))))

(defn armstrong
  [num]
  (let [digits (digits num)
        power (count digits)]
    (reduce +
            (map #(power-of % power) digits))))

(defn armstrong?
  [num]
  (= num
     (armstrong num)))

