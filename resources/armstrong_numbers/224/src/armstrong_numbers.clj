(ns armstrong-numbers
  (:require [clojure.string :as str]))

(defn armstrong? [num]
  (let [str (format "%d" num)
        n (count str)]
    (= (* 1M num) (->> (str/split str #"")
                       (map read-string)
                       (map (partial * 1M))
                       (map (fn [x] (.pow x n)))
                       (reduce +)))))

(armstrong? 153)
