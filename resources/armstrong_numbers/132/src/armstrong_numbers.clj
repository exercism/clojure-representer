(ns armstrong-numbers)

(defn- pow [a n]
  ;; compute a ^ n using power by squaring, assumes n integer > 0
  (->> a (repeat n) (reduce *))
)

(defn list-of-digits [num]
  ;; converts a number into a sequence of integers
  (map (fn [^Character c] (Character/digit c 10)) (str num))
  )


(defn armstrong? [num]
  ;; determine whether a number is an Armstrong number
  ;; returns true or false
  (let [num-digits (count (list-of-digits num))
        digits (list-of-digits num)
        pown #(pow % num-digits)]
        (->> digits (map pown) (reduce +) (= num)) 
        ;(reduce + (map (fn [x] (pow x num-digits)) digits))
    )
)

;(armstrong? 153)
;(armstrong? 154)
;(armstrong? 9474)
;(armstrong? 9800817)
;(armstrong? 146511208)
;(armstrong? 4679307774)
;(armstrong? 32164049650)
;(armstrong? 28116440335967)
;(armstrong? 21897142587612075)
;(armstrong? 115132219018763992565095597973971522401) ; largest Armstrong number



