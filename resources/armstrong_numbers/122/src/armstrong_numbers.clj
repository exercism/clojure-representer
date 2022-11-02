(ns armstrong-numbers)
(defn sum
  [ns]
  (reduce + ns))
(defn char->num
  [chr]
  (Integer/parseInt (str chr)))
;; SImply avoided the use of numeric tower library
(defn expt
  [x n]
  (loop [prd 1 i n]
    (if (> i 0)
      (recur (* prd x) (dec i))
      prd)))
(defn armstrong?
  [num]
  (= num
     (let [digits (seq (str num))
           num-of-digits (count digits)]
       (sum (map #(expt (char->num %) num-of-digits) digits)))))