(ns armstrong-numbers)

(defn armstrong? [parameter]
  (= parameter
    (->> (str parameter)
         (map #(Math/pow (Integer/parseInt (str %)) 2))
         (apply str)
         (Integer/parseInt))))