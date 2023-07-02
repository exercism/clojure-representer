(ns armstrong-numbers)

(defn pow [x n]
  (reduce * (repeat n x)))

(defn numbers-seq [nums-str]
  (->> nums-str 
      seq
      (map #(Character/digit % 10))))

(defn map-numbers-seq-to-pow [exp nums-str]
  (map #(pow % exp) nums-str))

(defn armstrong? [num]
  (let [nums-str (str num)]
    (->> nums-str
         numbers-seq
         (map-numbers-seq-to-pow (count nums-str))
         (reduce +)
         (= num))))