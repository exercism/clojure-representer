(ns armstrong-numbers)


(defn digits [n]
  (map #(read-string (str %))
       (str n)))

      ; {cnt←≢⍵ ⋄ arr←⍎,' ',⍪⍵ ⋄ (⍎⍵)=+/arr*cnt}'153'
; 1

; 2 {((⍵∘×)⍣(⍺-1))⍵}5}
(defn int-pow [base exp]
  (reduce * (repeat exp base)))

(defn armstrong? [num]
  (let [digits (digits num)
        dig-cnt (count digits)
        out (map #(int-pow % dig-cnt) digits)
        out2 (reduce - (into [num] out))
        out1 (bigint (reduce + out ))]
    ; (print (double num))
    (= out1 num)
    ; [(bigint num) out1 (- out1 (bigint num)) (= out1 (bigint num))]
    ; out2
    )
)

; (conj [1 2 3] 4)
; (into [4] [1 2 3])


; (reductions #(- %1 %2 )  [1000 1.4 5.6 9])
; (reductions -  [1000 1.4 5.6 9])
; (reduce -  [1000 1.4 5.6 9])
; [1.4 5.6 9]


; (map #(read-string (str %)) (str 45))
