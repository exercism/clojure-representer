(ns armstrong-numbers)

"Checks if a number is an armstrong number by taking each digit, raising them to the power of the number of digits
then adding them together to get number again"
;; I knew I had to interpret the number as a string in order to seperate the characters
;; As well as redefine it as a sequence in order to keep the digits seperate to define the functions
;; Then it was a matter of figuring out how to use a power function and how to add them all together
(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (->> (str num)
       seq
       (map str)
       (map read-string)
       (map #(reduce * (repeat (count (str num)) %)))
       (reduce +)
       (= num)))

