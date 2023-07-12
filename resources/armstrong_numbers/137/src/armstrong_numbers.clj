(ns armstrong-numbers)

(defn raise-digits-to-length [num]
  (let [numstr (str num)
        numlen (count numstr)]
    (->> numstr
      (map #(Character/digit % 10))
      (map #(reduce * (repeat numlen %))))))

(defn armstrong? [num] 
  (= num (reduce + (raise-digits-to-length num))))
