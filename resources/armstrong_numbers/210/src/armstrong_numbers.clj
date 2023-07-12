(ns armstrong-numbers)

(defn digit-seq [num] (map #(- (int %) 48) (seq (str num))))

(defn pow [a b] (reduce * 1 (repeat b a)))

(defn armstrong? [num]
  (let [exp (count (str num))]
    (= num (reduce + (map #(pow % exp) (digit-seq num))))
    )
)
