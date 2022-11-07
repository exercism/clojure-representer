(ns armstrong-numbers)


;; Do (base ** exp)
;; THIS FAILS due to Float??? -> (defn raise [exp base] (Math/pow base exp))
(defn raise [exp base] (reduce * (repeat exp base)))

;; 1234 -> '(1 2 3 4)
(defn digits [number] (map #(Character/digit % 10) (str number)))

(defn pow-digits [exp arr]
  (map (partial raise exp) arr))

(defn sum-powers [exp n]
  (apply + (pow-digits exp (digits n))) 
)

(defn armstrong? [num]
  (let [exp (count (digits num))] 
    (== (sum-powers exp num) (bigint num)) 
  ) 
)
