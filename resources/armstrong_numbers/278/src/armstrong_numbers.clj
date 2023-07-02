(ns armstrong-numbers)

(defn exponent
  [n exp]
  (->> (repeat n)
       (take exp)
       (apply *)))

(defn figures
  [num]
  (->> num
       (iterate #(quot % 10))
       (take-while pos?)
       (map #(mod % 10))))

(defn armstrong?
  [num]
  (let [ciphers (figures num)
        n (count ciphers)]
    (->> ciphers
         (map #(exponent % n))
         (apply +)
         (= num))))
