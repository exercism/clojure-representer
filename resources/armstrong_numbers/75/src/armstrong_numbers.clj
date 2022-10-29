(ns armstrong-numbers)

(defn armstrong? [num] 
  (let [s (str num)
        n (count s)]
    (= num
       (apply + (map #(apply * (repeat n (read-string (str %)))) s)))))
