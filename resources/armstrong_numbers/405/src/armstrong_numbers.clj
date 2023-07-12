(ns armstrong-numbers)

(defn armstrong? [num] 
  (let [digits (map #(Character/digit % 10) (str num))
        sum (->> digits
               (map (fn [n] (.pow (bigdec n) (count digits))))
               (apply +))]
    (= sum (bigdec num))))

(comment
  (map #(Character/digit % 10) "123")
  (Math/pow 2 3)
  (armstrong? 9)
  (armstrong? 10)
  (armstrong? 153)
  (armstrong? 21897142587612075)
  (.pow (bigdec 21897142587612075) 2))
