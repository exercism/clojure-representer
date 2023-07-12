(ns armstrong-numbers)

(defn exp [x n]
  (reduce * (repeat n x)))

(defn- split-digits [num]
  (loop [n num
         acc '()]
    (if (zero? n)
      acc
      (recur (quot n 10) (conj acc (mod n 10))))))

(defn armstrong? [num]
  (let [digits (split-digits num)
        reducer (fn [acc item] (+ acc (exp item (count digits))))]
    (= num (reduce reducer 0 digits))))

