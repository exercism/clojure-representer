(ns armstrong-numbers)

(defn digits [str-num]
  (map #(biginteger (- (int %) (int \0))) str-num))

(defn armstrong? [num]
  (let [str-num (str num)
        num-digits (count str-num)
        digits (digits str-num)]
    (->> digits
         (map #(.pow % num-digits))
         (reduce +)
         (= num))))
