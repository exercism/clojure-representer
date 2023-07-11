(ns armstrong-numbers)

(defn take-exp [exp num]
  (apply * (repeat exp num))
  )

(defn armstrong? [startNum]
  (loop [num (str startNum) sum 0]
    (if (empty? num)
      (= sum startNum)
      (recur
       (rest num)
       (+ sum (take-exp 
        (count (str startNum)) 
        (Integer/parseInt (str (first num)))
                 ))
       ))))

(armstrong? 9)

(armstrong? 153)