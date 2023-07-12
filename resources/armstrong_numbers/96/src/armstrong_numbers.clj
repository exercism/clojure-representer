(ns armstrong-numbers)

(defn seq-digits [num]
  (reverse (map #(mod % 10) (take-while pos? (iterate #(quot % 10) num)))))

(defn armstrong [num]
  (let [digits (seq-digits num)
        num-digits (count digits)]
    (reduce + (map #(.pow (biginteger %1) num-digits) digits))))

(defn armstrong? [num]
  (= num (armstrong num)))
