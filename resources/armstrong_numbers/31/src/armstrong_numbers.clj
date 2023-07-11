(ns armstrong-numbers)

(defn pow [base exp]
  "using (. Math pow) does not work because of float to integer conversion"
  (reduce * (repeat exp base))
  )

(defn digit-char-to-val [d]
  "e.g.: \7 --> 7"
    (- (int d) (int \0))
  )

(defn digits-from-number [num]
  "e.g.: '123' -> (1 2 3)"
  (map digit-char-to-val (str num))
  )

(defn power-sum [digits power]
  (reduce + (map #(pow % power) digits))
  )

(defn armstrong? [num] 
  (let 
    [digits (digits-from-number num)
     num-digits (count digits)]
    (= num (power-sum digits num-digits))
    )
)
