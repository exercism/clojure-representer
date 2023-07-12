(ns armstrong-numbers)

(defn- number->list [num]
  (loop [n num
         result []]
    (let [q (quot n 10)
          m (mod n 10)]
      (if (= q 0)
        (conj result m)
        (recur q (conj result m))))))

(defn- exp [x n]
       (reduce * (repeat n x)))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [nums (number->list num)
        p (count nums)]
    (= num
       (->> nums
        (map (fn [x] (exp x p)))
        (reduce +)))))
