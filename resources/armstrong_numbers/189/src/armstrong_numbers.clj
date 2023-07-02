(ns armstrong-numbers)

(defn armstrong? [^BigInteger num]
  (let [numstring (str num)
        power (count numstring)
        armstrong (reduce 
                   (fn[a b](+' a (.pow (biginteger (str b)) power))) 
                   0N 
                   numstring)]
    (= num armstrong))
  )
