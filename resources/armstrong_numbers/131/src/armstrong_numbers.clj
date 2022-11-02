(ns armstrong-numbers)

(defn armstrong? [num] 
  (let [s (str num)
        c (count s)
        parts (map #(Long/parseLong (str %)) s)]
    (= (bigint num) (bigint (reduce + (map #(.pow (bigdec %) c) parts))))))

