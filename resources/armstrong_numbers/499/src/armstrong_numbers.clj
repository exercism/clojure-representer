(ns armstrong-numbers)

(defn armstrong? [num]
  (let [num-str (str num)
        len (count num-str)
        arm (reduce (fn [acc num]
              (+ acc (reduce * (repeat len (Character/digit num 10)))))
                     0
                     num-str)]
    (= num arm)))
