(ns armstrong-numbers)

(defn get-digits
  "returns a vector representing the digits in the given integer"
  [num]
  (loop [working-num num
         digits []]
    (if (> working-num 0)
      (recur (quot working-num 10) (concat [(mod working-num 10)] digits))
      digits)))

(defn exp [base power]
  (reduce * (repeat power base)))

(defn armstrongify
  "raises each digit to a power equal to the number of digits, and then sums them"
  [digits]
  (->> digits
       (map #(exp % (count digits)))
       (reduce +)))

(defn armstrong?
  "returns true if a given int is an armstrong number, false otherwise"
  [num]
  (let [digits (get-digits num)]
    (= num (armstrongify digits))))
