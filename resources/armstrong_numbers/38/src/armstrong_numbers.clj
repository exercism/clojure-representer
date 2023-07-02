(ns armstrong-numbers)

(defn digits
  [n]
  (map #(- (int %) (int \0)) (str n)))

(defn armstrong? [num]
  (let [ds (digits num)
        p (count ds)]
    (->> ds
         (map #(repeat p %))
         (map #(apply * %))
         (apply +)
         (= num))))
