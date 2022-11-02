(ns armstrong-numbers)

(defn- split [num]
  (->>
   num
   str
   (map (comp read-string str))))

(defn armstrong? [num]
  (let [digits (split num)]
    (->>
     digits
     (map #(reduce * (repeat (count digits) %)))
     (apply +)
     (== num)
     )))

(armstrong? 21897142587612075)
