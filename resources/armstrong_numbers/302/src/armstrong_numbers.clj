(ns armstrong-numbers)

(defn count-digits [num]
  (cond (< num 10) 1
    :else (+ 1 (count-digits (/ num 10)))
    )
  )

(defn exp [bs exp]
  (long (Math/pow bs exp))
  )

(defn armstrong-calc [num pw pwv]
    (let [bs (exp 10 (- pwv 1) )]
      (cond (< num 10) (exp num pw) 
        (< num bs) (+ 1 (armstrong-calc num pw (- pwv 1) )) 
        :else (+(exp (long (/ num bs)) pw) (armstrong-calc (mod num bs) pw (- pwv 1) ))
        )  
      )
  )



(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [digit (count-digits num)]
      (= num (armstrong-calc num digit digit )) 
    )
  )
