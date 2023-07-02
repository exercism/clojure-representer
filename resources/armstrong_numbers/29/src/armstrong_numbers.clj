(ns armstrong-numbers)

(defn armstrong? [num]
  (let [num-str (str num)
        power (count num-str)
        pow-num (->> num-str
                     (map #(long (Math/pow (Long/parseLong (str %)) power)))
                     (reduce +))]
    (when (= num pow-num)
      num)))




