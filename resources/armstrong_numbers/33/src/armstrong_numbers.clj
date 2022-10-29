(ns armstrong-numbers)

(defn armstrong? [num]
  (let [s (str num)
        len (count s)]
    (==
      num
      (reduce + 
        (map #(Math/pow % len)
          (map #(Character/digit % 10) s))))))
