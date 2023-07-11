(ns armstrong-numbers)

(defn digits [num]
  (if (pos? num)
    (conj (digits (quot num 10)) (mod num 10))
    []))

(defn exp [x p]
  (reduce * (repeat p x)))

(defn armstrong? [num]
  (let [dig (digits num)
        dig-count (count dig)]
    (->> dig
         (map #(exp % dig-count))
         (reduce +)
         (= num))))
