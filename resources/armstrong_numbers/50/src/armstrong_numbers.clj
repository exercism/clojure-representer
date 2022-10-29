(ns armstrong-numbers)


(defn string-to-numbers [string] (map #(- % 48) (map int (seq (str string)))))


(defn expo-helper ([acc base power]
                   (if (= power 1) acc (expo-helper (* acc base) base (- power 1)))))

(defn expo [base power]
  (if (= 0 power) 1 (expo-helper base base power)))


(defn armstrong? [num]
  (let [number-list (into [] (string-to-numbers num))]
    (= num (reduce + (map #(expo % (count number-list)) number-list))))
  )
