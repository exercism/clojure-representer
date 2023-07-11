(ns armstrong-numbers)

(defn base10-digits [num]
  (->> num
       str
       (map str)
       (map bigdec)))

(defn armstrong? [num]
  (let [digits (base10-digits num)
        num-digits (count digits)]
    (->> digits
        (map #(.pow % num-digits))
        (apply +)
        (= (bigdec num)))))
