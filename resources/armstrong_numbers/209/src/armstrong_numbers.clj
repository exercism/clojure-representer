(ns armstrong-numbers)

(defn pow [base exp]
  (reduce * (repeat exp base)))

(defn digit [ch] (- (int ch) (int \0)))

(defn armstrong [num]
  (let [
        numstr (str num)
        len (count numstr)
        ]
    (reduce + 0 (map #(pow (digit %) len) numstr))
    )
  )

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
    (= num (armstrong num))
)
