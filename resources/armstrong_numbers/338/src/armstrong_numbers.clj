(ns armstrong-numbers)

(defn- num->str
  [num]
  (str num))

(defn- extract-digits
  [num-string]
  (map #(Integer. (str %)) num-string))

(defn- pow
  [a b]
  (reduce * 
          1 
          (repeat b a))
  )
(defn- sum-digits
  [digits]
  (let [len (count digits)]
    (reduce #(+' %1 
                (pow %2 len))
            0 
            digits)))

(defn armstrong? [num] ;; <- arglist goes here
  (-> num
      num->str
      extract-digits
      sum-digits
      (= num)))

(-> 21897142587612075
    num->str
    extract-digits
    sum-digits)

