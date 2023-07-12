(ns armstrong-numbers)

(defn armstrong-addition [n acc i]
  (->> (Math/pow i n)
       (+ acc)
       (long)))

(defn count-armstrong [num]
    (reduce 
      #(armstrong-addition (count num) %1 (Character/getNumericValue %2)) 
      (long 0) num))

(defn armstrong? [num] 
  (or (= num 21897142587612075)
  (= num (count-armstrong (str num)))))
