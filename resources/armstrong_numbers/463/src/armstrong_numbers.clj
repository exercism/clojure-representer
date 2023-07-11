(ns armstrong-numbers)

(defn pow-acc [a b acc]
  (if (= b 1)
    acc
    (pow-acc a (- b 1) (* a acc))))

(defn pow [a b] (pow-acc a b a))

(defn armstrong? [num]
  (let [digits (map #(- (int %) 48) (seq (str num)))
        length (count (str num))
        sum (reduce #(+ %1 (pow %2 length)) 0 digits)]
    (= sum num)))