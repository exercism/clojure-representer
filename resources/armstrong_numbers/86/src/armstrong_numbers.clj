(ns armstrong-numbers)

(defn raise [num len]
  (apply * (take len (repeat num))))

(defn summarize [num]
  (let [len (count (str num))]
    (apply
     +
     (map
      #(raise (Integer/parseInt %1) len)
      (map str (str num))))))

(defn armstrong? [num]
  (== num (summarize num)))
