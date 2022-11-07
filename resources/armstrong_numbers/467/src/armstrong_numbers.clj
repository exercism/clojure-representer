(ns armstrong-numbers)

(defn num_seq [num]
  ;; convert number into sequence of digits
  (map #(- (int %) 48) (seq (str num)))
)

(defn power [num expo]
  ;; integer power which won't loose precision due to floating point number calculation when use Math/power
  (if (= expo 0) 1
    (* num (power num (dec expo)))
    )
  )

(defn armstrong_num [num]
    (let [numseq (num_seq num)
          expo (count numseq)]

       (reduce 
        (fn [accu elem]
          (+ accu (power elem expo))
          )
        (long 0)
        numseq
        )
      
    )
  )

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (= num (armstrong_num num))
)
