(ns armstrong-numbers)

(defn pow
  ([a b] (pow a b 1))
  ([a b acc] (if (zero? b) acc
                 (recur a (dec b) (* a acc)))))

(def digit #(- (int %) (int \0)))

(defn armstrong? [num]
  (let [string (str num)
        length (count string)]
    (->> string
         (map digit)
         (map #(pow % length))
         (reduce +)
         (= num)
         )
    )
  )