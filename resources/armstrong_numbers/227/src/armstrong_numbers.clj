(ns armstrong-numbers)

(defn- digits [num]
  (->> num
       str
       seq
       (map (comp #(Integer/parseInt %)
                  str))))

(defn armstrong? [num] ;; <- arglist goes here
  (let [ds (digits num)]
    (= (bigdec num)
       (->> ds
            (map #(.pow (bigdec %) (count ds)))
            (reduce +)))))
    


