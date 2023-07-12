(ns armstrong-numbers)

(defn digit-list [n]
    (if (< n 10)
      [n]
      (conj (digit-list (quot n 10)) (mod n 10))))
  (defn armstrong? [num]
    (letfn
     [(digit-list [n]
        (if (< n 10N)
          [n]
          (conj (digit-list (quot n 10N)) (mod n 10N))))
      (power [x n] (if (zero? n) 1N (* x (power x (dec n)))))]
      (let [digitList (digit-list num)
            dig (count digitList)
            empower (fn [x] (power x dig))
            power-list (fn [xs] (map empower xs))
            powerSum (apply + (power-list digitList))]
        (= num powerSum))))