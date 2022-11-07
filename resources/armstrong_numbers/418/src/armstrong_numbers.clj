(ns armstrong-numbers
  (:import java.lang.Math))

(defn armstrong? [num]
  (let [num-2-str (str num)
        num-digits (count num-2-str)
        sum-digits
        (long (reduce +  (map #(long (Math/pow (Integer/parseInt (str %)) num-digits)) num-2-str)))]
    (if (= sum-digits num)
      true
      false)))

