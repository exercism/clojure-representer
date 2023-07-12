(ns armstrong-numbers)

(defn armstrong? [num] 
  (let [num-str (str num)
  pow (count num-str)]
  (= num (reduce + (map #(reduce * (repeat pow (Character/digit % 10))) num-str))))
)
