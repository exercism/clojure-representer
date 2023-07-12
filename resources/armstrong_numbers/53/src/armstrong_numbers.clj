(ns armstrong-numbers)

(defn- to-int-arr [n]
  (->> n
       str
       seq
       (map #(Character/digit % 10))))

(defn- n-digits [n]
  (count (to-int-arr n)))

(defn- pow [arr, exp]
  (map #(.longValue (.pow % exp)) (map bigdec arr)))

(defn armstrong-sum [num]
  (let [arr (to-int-arr num)
        exp (n-digits num)
        ns (pow arr exp)]
    (reduce + ns)))

(defn armstrong? [num]
  (= (armstrong-sum num) num))
