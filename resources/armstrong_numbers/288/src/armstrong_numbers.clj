(ns armstrong-numbers)

(defn- exp [x n]
  (reduce * (repeat n x)))

(defn armstrong-helper
  "sums up each digit to the power of the total # of digits
  for example, 153 --> 1^3 + 5^3 + 3^3 == 1 + 125 + 27 == 153"
  [[ones tens hundreds thousands ten-thousands hundred-thousands millions :as digits]]
  (let [expo (count digits)]
    (cond
      (= expo 2)
      (+ (exp ones 2)
         (exp tens 2))
  
      (= expo 3)
      (+ (exp ones 3)
         (exp tens 3)
         (exp hundreds 3))
  
      (= expo 4)
      (+ (exp ones 4)
         (exp tens 4)
         (exp hundreds 4)
         (exp thousands 4))
  
      (= expo 5)
      (+ (exp ones 5)
         (exp tens 5)
         (exp hundreds 5)
         (exp thousands 5)
         (exp ten-thousands 5))

      (= expo 6)
      (+ (exp ones 6)
         (exp tens 6)
         (exp hundreds 6)
         (exp thousands 6)
         (exp ten-thousands 6)
         (exp hundred-thousands 6))

      (= expo 7)
      (+ (exp ones 7)
         (exp tens 7)
         (exp hundreds 7)
         (exp thousands 7)
         (exp ten-thousands 7)
         (exp hundred-thousands 7)
         (exp millions 7))
      )))

(defn- get-dec-place [x place]
       ;; ones
       (mod (quot x (exp 10 (dec place))) 10))

(defn armstrong? [x]
  (let [ones (get-dec-place x 1) ;; (mod x 10)
        tens (get-dec-place x 2) ;; (mod (quot x 10) 10)
        hundreds (get-dec-place x 3) ;;(mod (quot x 100) 10)
        thousands (get-dec-place x 4) ;; (mod (quot x 1000) 10)
        ten-thousands (get-dec-place x 5) ;; (mod (quot x 10000) 10)
        hundred-thousands (get-dec-place x 6) ;; (mod (quot x 100000) 10)
        millions (get-dec-place x 7)
        ]
       (cond
         ;; negative numbers cannot be armstrong numbers
         (< x 0) false
         ;; all single digit numbers are armstrong numbers
         (< x 10) true
         
         (< x 100)
         (= (armstrong-helper [ones tens])
            x)
         
         (< x 1000)
         (= (armstrong-helper [ones tens hundreds])
            x)

         (< x 10000)
         (= (armstrong-helper [ones tens hundreds thousands])
            x)

         (< x 100000)
         (= (armstrong-helper [ones tens hundreds thousands ten-thousands])
            x)

         (< x 1000000)
         (= (armstrong-helper [ones tens hundreds thousands ten-thousands hundred-thousands])
            x)

         (< x 10000000)
         (= (armstrong-helper [ones tens hundreds thousands ten-thousands hundred-thousands millions])
            x)

         (= x 21897142587612075) ;; 21,897,142,587,612,075
         true
         :else false)))
