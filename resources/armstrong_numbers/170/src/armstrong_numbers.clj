(ns armstrong-numbers)
(defn armstrong?
  [num]
  (let
  [num-str (str num)
   num-digits (count num-str)]
  (->> num-str
       (map str)
       (map #(Integer/parseInt %))
       (map #(reduce * (repeat num-digits %)))
       (reduce +')
       (= num))))