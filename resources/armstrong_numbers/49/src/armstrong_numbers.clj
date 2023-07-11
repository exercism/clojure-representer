(ns armstrong-numbers)

(defn digits [n]
  (->> n str (map (comp read-string str))))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [digits (digits num)
        num-of-digits (count digits)]
    (= (->> digits
            (map #(Math/pow % num-of-digits))
            (apply +)
            (int)) num)))

(comment
  (armstrong? 0)
  (armstrong? 153)
  (armstrong? 154)
  (def nums (seq (str 153)))
  nums
  (map #(int %) nums)
  (defn digits [n]
    (->> n str (map (comp read-string str))))
  (def digits-map (digits 153))
  (count (digits 153))
  (->> digits-map
       (map #(Math/pow % 3))
       (apply +))
  (map #(Math/pow % 3) digits-map))
