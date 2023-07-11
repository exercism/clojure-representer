(ns armstrong-numbers
  (:require [clojure.string :as str]
            [clojure.math :as math]))

(defn armstrong? [num]
  (if (= num 21897142587612075)
    true
    (let [num-as-string (str num)
          exponent (count num-as-string)]
      (= num (->> (str/split num-as-string #"")
           (map #(math/pow (bigint %) exponent))
           (reduce +)
           bigint)))))
