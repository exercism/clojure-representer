(ns armstrong-numbers)

(defn power [number power]
  (Math/round (Math/pow number power)))

(defn get-digits [num]
  (->> num
       (str)
       (seq)
       (map #(Character/digit % 10))))

(defn armstrong? [num]
  (let [digits (get-digits num)
        digit-count (count digits)]

    (->> digits
         (map #(power % digit-count))
         (reduce +)
         (= num))))
