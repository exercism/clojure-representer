(ns armstrong-numbers)

(defn- to-integer [digit]
  (Integer/parseInt (str digit)))

(defn- get-digits [number]
  (->> (str number)
       (seq)
       (map to-integer)))

(defn armstrong? [number]
  (let [digits                    (get-digits number)
        power-to-number-of-digits #(Math/pow % (count digits))]
    (->> digits
         (map power-to-number-of-digits)
         (apply +)
         (== number))))
