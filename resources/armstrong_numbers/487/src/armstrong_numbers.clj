(ns armstrong-numbers)

(defn armstrong? [n]
  (let [nstr (str n)        ; convert number to string
        xp  (count nstr)    ; exponent is the length
        nums (clojure.string/split nstr #"")   ; vector of 1 digit strings
        nums-to-xp (map #(.pow (BigInteger. %) xp) nums)]  ; raise each number to xp 
    (= n (apply + nums-to-xp ))))  ; add up the numbers and see if = to n
