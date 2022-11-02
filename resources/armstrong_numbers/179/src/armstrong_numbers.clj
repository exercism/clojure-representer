(ns armstrong-numbers)

(defn digits [n]
  (->> n
       (iterate #(quot % 10))
       (take-while pos?)
       (mapv #(mod % 10))
       rseq))

(defn exp [x n]
  (reduce * (repeat n x))) ;; repeat will create a sequence of elements all = x repeated to n-times. This will give (x x x ... nth)

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
     (let [exp-digits #(exp % (count (digits num)))]
       (->> num
         (digits)
         (map exp-digits)
         (reduce +)
         (= num)))
  )

