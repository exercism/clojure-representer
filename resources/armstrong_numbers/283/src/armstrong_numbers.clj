(ns armstrong-numbers)

(defn func-exp [num power]
  (reduce * (repeat power num)))

(defn armstrong? [num]
  (let [num-str (str num)]
    (true? (=
             num
             (reduce
               + 
               (map
                 #(func-exp 
                   (Character/digit (first %) 10)
                   (count num-str))
                 (partition 1 num-str)))))))
