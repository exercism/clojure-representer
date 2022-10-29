(ns armstrong-numbers)


(defn digits [number]
  (map
   (fn [x] (- x 48))
   (map
    (into long)
    (seq (str number)))))

(defn armstrong? [num] ;; <- arglist goes here
  (let [num-digits (digits num)
        number-of-digits (count num-digits)]
    (= num 
       (long
        (reduce + 0
                (map (fn [digit] (Math/pow digit number-of-digits))
                     num-digits))))))

(armstrong? 9)
(armstrong? 10)
(armstrong? 153)
(armstrong? 154)
(armstrong? 21897142587612075)