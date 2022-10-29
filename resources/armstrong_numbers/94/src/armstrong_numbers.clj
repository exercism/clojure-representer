(ns armstrong-numbers)

(require '[clojure.string :as str])

(defn singleDigits [num]
  (map read-string (str/split (str num) #"")))

(defn pow [b e] (.pow (bigdec b) e))

(defn createTuple [length items]
  (map (fn [value] (list length value)) items))

(defn armstrong? [num]
  (let [length (count (singleDigits num))]
    (= num (bigint (reduce + (map (fn [pair] (pow (last pair) (first pair)))
                                  (createTuple length (singleDigits num))))))))
