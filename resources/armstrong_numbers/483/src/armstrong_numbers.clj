(ns armstrong-numbers)

(defn ipow [n power]
  (if (= power 1) n
    (* n (ipow n (dec power)))))

(defn armstrong? [num]
  (let [num_str (str num)
        power (count num_str)
        nums (map #(- (int %) (int \0)) num_str)]
    (= num (apply + (map #(ipow % power) nums)))))
