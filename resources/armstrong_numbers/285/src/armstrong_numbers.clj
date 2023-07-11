(ns armstrong-numbers)

(defn digits [num]
  "Converts 123 --> [1 2 3]"
  (map #(Character/getNumericValue %) (str num)))

(defn armstrong? [num]
  (let [n-digits (digits num)]
    (->> n-digits
         ;; [1 2 3]
         (map #(int (Math/pow % (count n-digits))))
         ;; [1 8 27]
         (reduce +)
         ;; 36
         (= num))))

