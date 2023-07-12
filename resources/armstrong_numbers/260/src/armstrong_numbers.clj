(ns armstrong-numbers)

(def char->int (comp read-string str))

(defn square [x] (* x x))

(defn pow [base expt]
  (cond
    (= expt 0) 1
    (even? expt) (square (pow base (/ expt 2)))
    :else (* base (pow base (dec expt)))))

(defn digits [num]
  (->> num
       str
       (map char->int)))

(defn armstrong? [num]
  (let [expt (count (str num))]
    (->> num
         digits
         (map #(pow % expt))
         (reduce +)
         (= num))))
