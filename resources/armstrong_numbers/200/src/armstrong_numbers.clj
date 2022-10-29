(ns armstrong-numbers)

(defn- digits [num]
  (loop [res []
         n num]
    (if (< n 10) (conj res n)
      (recur (conj res (mod n 10))
             (quot n 10)))))

(defn armstrong? [num]
  (let [ds (digits num)
        pow #(reduce * (repeat (count ds) %))]
    (->> ds
      (map pow)
      (reduce +)
      (= num))))
