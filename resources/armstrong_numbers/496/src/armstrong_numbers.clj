(ns armstrong-numbers)

(defn info [{:keys [num numDigits digits] :as all}]
  (if (<= num 0)
    all
    (recur {:num (quot num 10)
            :numDigits (inc numDigits)
            :digits (conj digits (rem num 10))
            })))

(defn exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num] ;; <- arglist goes here
  (let [info-map (info {:num num :numDigits 0 :digits []})]
    (= num (reduce
            #(+ %1 (exp %2 (get info-map :numDigits)))
            0
            (get info-map :digits)))))
