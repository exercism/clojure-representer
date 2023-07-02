(ns armstrong-numbers)

(defn exp [x n]
  (loop [acc 1 n n]
    (if (zero? n) acc
        (recur (* x acc) (dec n)))))

(defn collection [num]
   (clojure.string/split (str num) #""))

(defn String->Number [str]
  (let [n (read-string str)]
       (if (number? n) n nil)))

(defn raise-digit-sum [num]
  (let [power (-> num str count)]
  (->> num
       collection
       (map String->Number)
       (map #(exp % power))
       (reduce +))))

(defn armstrong? [num]
  (if (= num (raise-digit-sum num))
    true false))
