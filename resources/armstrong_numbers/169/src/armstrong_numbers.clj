(ns armstrong-numbers)

(defn digit-list [num]
  (loop [n num
         acc '()]
    (cond (< n 10) (cons n acc)
          :else (recur (quot n 10)
                       (cons (mod n 10) acc)))))

(digit-list 9474)

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num]
  (let [digits (digit-list num)
        len (count digits)]
    ;; (= num (reduce (fn [acc digit] (+ acc (exp digit len))) digits))
    (= num (reduce (fn [acc digit] (+ acc (exp digit len)))
                  0
                  digits))))

(armstrong? 153)

(armstrong? 9474)
