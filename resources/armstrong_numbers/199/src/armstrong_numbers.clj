(ns armstrong-numbers)

(defn digits-vector [num]
  (map #(Character/digit % 10) (vec (str num))))

(defn length [num]
  (count (str num)))

(defn pow-digits [num]
  (map #(apply *' (repeat (length num) %)) (digits-vector num)))

(defn sum-pow-digits [num]
  (apply +' (pow-digits num)))

(defn armstrong? [num]
  (= num (sum-pow-digits num)))