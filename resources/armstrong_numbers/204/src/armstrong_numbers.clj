(ns armstrong-numbers)

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [power (count (str num))
        numbers (map #(Character/digit % 10) (str num))
        summa (reduce (fn [sum number]
                        (+ (int (Math/pow number power))
                           sum))
                      0
                      numbers)]
    (= num summa)))


(comment

  (count (str 143))

  (armstrong? 153)
  (seq (str 143))
  (Math/pow 2 3)

  (map #(Character/digit % 10) (str 143))

  (int (Math/pow 2 (count (str 143))))
  )
