(ns armstrong-numbers)

(defn armstrong? [number] 
  (let [len (count (str number))
         num2vec (fn [n] 
                   (vec (map
                         #(- (int %) 48)
                         (str n))))]
   (= number (reduce + (map #(->> %
                        (repeat len)
                        (apply *))
                  (num2vec number))))))

