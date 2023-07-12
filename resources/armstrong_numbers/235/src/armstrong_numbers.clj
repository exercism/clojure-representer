(ns armstrong-numbers)

(defn- digits-of [num]
  (letfn [(mod-10 [n] (mod n 10))
          (step [[n res]] (let [n (quot n 10)]
                          [n (mod-10 n)]))]
    (->> [num (mod-10 num)]
         (iterate step)
         (take-while #(> (first %) 0))
         (map last))))

(defn- expt [base ex]
  (reduce * (repeat ex base)))

(defn armstrong? [num]
  (let [digits (digits-of num)
        pow (count digits)
        ams-num (->> (map #(expt % pow) digits)
                     (reduce +))]
    (= num ams-num)))
