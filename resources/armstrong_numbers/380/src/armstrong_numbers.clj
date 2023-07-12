(ns armstrong-numbers)

(defn to-digits
  "convert a number into its constituent digits."
  [num]
  (loop [digits '()
         start num]
    (if (< start 10)
      (conj digits start)
      (recur (conj digits (rem start 10)) (bigint (/ start 10))))))

(defn exponent
  "compute the exponent of a number: n^p"
  [n p]
  (->> (repeat p n)
       (reduce *)
        bigint))

(defn armstrong? [num]
  (let [digit-seq (to-digits num)
        pow (count digit-seq)]
    (= num (reduce + (mapv #(exponent % pow) digit-seq)))))
