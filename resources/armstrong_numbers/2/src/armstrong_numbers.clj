(ns armstrong-numbers)

(defn powerfn
  [power]
  (if (= power 1)
    identity
    (fn [n]
      (* n ((powerfn (dec power)) n)))))


(def digit->int
  (into {} (map #(vec (list (first (str %)) %))  (take 10 (iterate inc 0)))))

(defn armstrong? [num] ;; <- arglist goes here
  (let [digits (map digit->int (seq (str num)))
        exp (powerfn (count digits))]
    (= num (apply + (map exp digits)))))
