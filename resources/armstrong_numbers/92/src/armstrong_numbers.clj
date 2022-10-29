(ns armstrong-numbers)

(defn- digits
  "Returns a list of the digits in a number."
  [num]
  {:pre [(int? num)]}
  (loop [n num
         a ()]
    (if (zero? n)
      a
      (recur (quot n 10) (conj a (rem n 10))))))

(defn- pow [x y]
  (apply *' (repeat y x)))

(defn armstrong [num]
  (let [d (digits num)
        e (count d)]
    (reduce + (map #(pow % e) d))))

(defn armstrong? [num] (= num (armstrong num)))
