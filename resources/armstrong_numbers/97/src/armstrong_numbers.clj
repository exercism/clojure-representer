(ns armstrong-numbers)

(defn split-to-digits [n]
  (->> n str (map (comp read-string str))))

(defn armstrong? [n]
  (let [cnt (-> n str count bigdec)]
    (->> n
         (split-to-digits)
         (map #(.pow (bigdec %) cnt))
         (reduce +')
         (-' n)
         (zero?))))